package de.samples.apicomparison.consumer.clients.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("application.webclient")
public record WebClientConfig(
  String baseUrl,
  int timeout
) {
}
