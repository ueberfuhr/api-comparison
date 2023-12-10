package de.samples.apicomparison.consumer.clients.soap.config;

import de.samples.apicomparison.consumer.clients.config.ApiConfig;
import de.samples.apicomparison.consumer.clients.config.WebClientMutator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class SoapWebClientConfiguration {

  private final WebClientMutator mutator;

  @Bean
  @ConfigurationProperties(prefix = "application.apis.soap")
  ApiConfig soapApiConfig() {
    return new ApiConfig();
  }

  @Bean
  @SoapWebClient
  WebClient soapWebClient() {
    return this.mutator.mutate(soapApiConfig());
  }

}
