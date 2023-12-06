package de.samples.apicomparison.consumer.clients.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.webclient")
public record WebClientConfig(
  String baseUrl,
  int timeout
) {
}
