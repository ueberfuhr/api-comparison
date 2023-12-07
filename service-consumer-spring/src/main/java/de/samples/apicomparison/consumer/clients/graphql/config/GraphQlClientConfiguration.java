package de.samples.apicomparison.consumer.clients.graphql.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class GraphQlClientConfiguration {

  @Bean
  public HttpGraphQlClient httpGraphQlClient(
    @GraphQlWebClient
    WebClient webClient
  ) {
    return HttpGraphQlClient
      .builder(webClient)
      .build();
  }

}
