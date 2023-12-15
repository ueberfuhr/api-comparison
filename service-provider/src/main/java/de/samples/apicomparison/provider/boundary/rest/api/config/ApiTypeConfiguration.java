package de.samples.apicomparison.provider.boundary.rest.api.config;

import io.swagger.v3.oas.models.Paths;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ApiTypeConfiguration {

  private final ApiTypeConfigurationProperties config;

  /*
   * This will configure WebMVC controller's request mapping by adding the "api/v1" prefix.
   */
  @Bean
  WebMvcConfigurer configureApiTypesToWebMvc() {
    return new WebMvcConfigurer() {
      @Override
      public void configurePathMatch(@SuppressWarnings("NullableProblems") PathMatchConfigurer configurer) {
        for (ApiTypeConfigurationProperties.ApiType apiType : config.getApis()) {
          configurer.addPathPrefix(
            apiType.getBasePath(),
            HandlerTypePredicate.forAnnotation(apiType.getAnnotation())
          );
        }
      }

    };
  }

  private static String normalizeBasePath(String basePath) {
    if (null == basePath) {
      return null;
    }
    basePath = basePath.trim();
    if (basePath.isEmpty() || "/".equals(basePath)) {
      return null;
    }
    if (!basePath.startsWith("/")) {
      basePath = "/" + basePath;
    }
    if (basePath.endsWith("/")) {
      basePath = basePath.substring(0, basePath.length() - 2);
    }
    return basePath;
  }

  /*
   * This customizes the generated OpenAPI by removing the "api/v1" prefix from
   * the paths and appending it directly to the server url.
   * Instead
   *
   * servers:
   *   - url: http://localhost:8081
   * paths:
   *   /api/v1/blogposts:
   *     ...
   *
   * we will get

   * servers:
   *   - url: http://localhost:8081/api/v1
   * paths:
   *   /blogposts:
   *     ...
   *
   */
  @Bean
  OpenApiCustomizer apiTypeBasePathCustomizer() {
    return api -> {
      for (ApiTypeConfigurationProperties.ApiType apiType : config.getApis()) {
        var basePath = normalizeBasePath(apiType.getBasePath());
        if (null != basePath) {
          final var containsOnlyApiTypeMatchingPaths =
            api.getPaths()
              .keySet()
              .stream()
              .filter(path -> !path.startsWith(basePath + "/"))
              .findFirst()
              .isEmpty();
          if (containsOnlyApiTypeMatchingPaths) {
            // add base path to server urls
            api.getServers()
              .forEach(server -> server.setUrl(server.getUrl() + basePath));
            // remove base path from paths
            api.setPaths(
              api.getPaths()
                .entrySet()
                .stream()
                .reduce(
                  new Paths(),
                  (paths, path) -> paths.addPathItem(
                    path.getKey().substring(basePath.length()),
                    path.getValue()
                  ),
                  (p1, p2) -> {
                    p2.forEach(p1::addPathItem);
                    return p1;
                  }
                )
            );
            return;
          }
        }
      }
    };
  }


}
