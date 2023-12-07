package de.samples.apicomparison.consumer.clients.config;

import io.netty.channel.ChannelOption;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
@EnableConfigurationProperties(WebClientConfig.class)
public class WebClientAutoConfiguration {

  @Primary
  @Bean
  WebClient webClient(WebClientConfig config) {
    HttpClient httpClient = HttpClient.create()
      .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, config.timeout())
      .responseTimeout(Duration.ofMillis(config.timeout()));
    return WebClient.builder()
      .clientConnector(new ReactorClientHttpConnector(httpClient))
      .baseUrl(config.baseUrl())
      .build();
  }

  @Bean
  WebClientMutator webClientMutator(final WebClientConfig config, final WebClient webClient) {
    return mutation -> webClient
      .mutate()
      .baseUrl(config.baseUrl() + (null != mutation.getEndPoint() ? mutation.getEndPoint() : ""))
      .build();
  }

}
