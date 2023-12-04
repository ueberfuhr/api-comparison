package de.samples.apicomparison.provider.boundary.rest.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;

@Component
@ConfigurationProperties("application")
@Getter
@Setter
public class ApiTypeConfigurationProperties {

  private List<ApiType> apis;

  @Getter
  @Setter
  public static class ApiType {
    private String basePath = "/";
    private Class<? extends Annotation> annotation;
  }

}
