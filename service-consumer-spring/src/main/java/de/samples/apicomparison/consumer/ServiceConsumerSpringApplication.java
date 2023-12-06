package de.samples.apicomparison.consumer;

import de.samples.apicomparison.consumer.clients.rest.config.EnableHttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHttpClients
public class ServiceConsumerSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceConsumerSpringApplication.class, args);
  }

}
