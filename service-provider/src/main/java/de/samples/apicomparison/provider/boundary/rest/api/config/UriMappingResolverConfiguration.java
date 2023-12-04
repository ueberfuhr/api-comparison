package de.samples.apicomparison.provider.boundary.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class UriMappingResolverConfiguration {

  @Bean
  UriMappingResolver uriMappingResolver(@Lazy List<RequestMappingHandlerMapping> m) {
    return new UriMappingResolver(
      () -> m.stream()
        .map(RequestMappingHandlerMapping::getPathPrefixes)
        .map(Map::entrySet)
        .flatMap(Set::stream)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
    );
  }

  @Bean
  WebMvcConfigurer configureUriMappingResolverToWebMvc(final UriMappingResolver resolver) {
    return new WebMvcConfigurer() {
      @Override
      public void addArgumentResolvers(
        @SuppressWarnings("NullableProblems")
        List<HandlerMethodArgumentResolver> resolvers
      ) {
        resolvers.add(new HandlerMethodArgumentResolver() {
          @Override
          public boolean supportsParameter(
            @SuppressWarnings("NullableProblems")
            MethodParameter parameter
          ) {
            return parameter
              .getParameterType()
              .equals(UriMappingResolver.class);
          }

          @Override
          public Object resolveArgument(
            @SuppressWarnings("NullableProblems")
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            @SuppressWarnings("NullableProblems")
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
          ) {
            return resolver;
          }
        });
      }
    };
  }

}
