package de.samples.apicomparison.consumer.clients.soap.config;

import de.samples.apicomparison.consumer.clients.soap.HttpSoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SoapClientConfiguration {

  @Bean
  HttpSoapClient httpSoapClient(@SoapWebClient WebClient webClient) {
    return new HttpSoapClient(webClient);
  }

}
