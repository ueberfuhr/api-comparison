package de.samples.apicomparison.provider.boundary.config;

import de.samples.apicomparison.provider.boundary.rest.api.V1Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpHeaders.*;

@Configuration
public class WebConfiguration {

  @Bean
  WebMvcConfigurer configureWeb(CorsConfigurationProperties allowed) {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(@SuppressWarnings("NullableProblems") CorsRegistry registry) {
        registry.addMapping("/**")
          .exposedHeaders(LOCATION, LINK)
          .allowedHeaders(ORIGIN, CONTENT_TYPE, ACCEPT, ACCEPT_LANGUAGE, IF_MATCH, IF_NONE_MATCH, AUTHORIZATION)
          .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
          .allowedOrigins(allowed.getOrigins())
          .allowCredentials(allowed.isCredentials());
      }

      @Override
      public void configurePathMatch(@SuppressWarnings("NullableProblems") PathMatchConfigurer configurer) {
        configurer.addPathPrefix(
          "/api/v1",
          HandlerTypePredicate.forAnnotation(V1Api.class)
        );
      }

    };
  }

}
