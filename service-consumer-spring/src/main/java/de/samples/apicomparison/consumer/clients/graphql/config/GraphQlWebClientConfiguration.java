package de.samples.apicomparison.consumer.clients.graphql.config;

import de.samples.apicomparison.consumer.clients.config.ApiConfig;
import de.samples.apicomparison.consumer.clients.config.WebClientMutator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class GraphQlWebClientConfiguration {

  private final WebClientMutator mutator;

  @Bean
  @ConfigurationProperties(prefix = "application.apis.graphql")
  ApiConfig graphQlApiConfig() {
    return new ApiConfig();
  }

  @Bean
  @GraphQlWebClient
  WebClient graphQlWebClient() {
    return this.mutator
      .mutate(graphQlApiConfig());
  }

}
