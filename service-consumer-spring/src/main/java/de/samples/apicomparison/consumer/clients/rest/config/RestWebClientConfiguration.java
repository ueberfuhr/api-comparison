package de.samples.apicomparison.consumer.clients.rest.config;

import de.samples.apicomparison.consumer.clients.config.ApiConfig;
import de.samples.apicomparison.consumer.clients.config.WebClientMutator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class RestWebClientConfiguration {

  public static final String REST_WEBCLIENT_BEAN_NAME = "restWebClient";

  private final WebClientMutator mutator;

  @Bean
  @ConfigurationProperties(prefix = "application.apis.rest")
  ApiConfig restApiConfig() {
    return new ApiConfig();
  }

  @Bean(REST_WEBCLIENT_BEAN_NAME)
  @RestWebClient
  WebClient restWebClient() {
    return this.mutator.mutate(restApiConfig());
  }

}
