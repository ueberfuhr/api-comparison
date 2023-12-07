package de.samples.apicomparison.consumer.clients.config;

import org.springframework.web.reactive.function.client.WebClient;

@FunctionalInterface
public interface WebClientMutator {

  WebClient mutate(ApiConfig mutation);

}
