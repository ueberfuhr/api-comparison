# Representational State Transfer (REST) - Spring Boot Service Consumer

For the consumer, we use the [HTTP Interface Client](https://docs.spring.io/spring-framework/reference/web/webflux-http-interface-client.html).
This has to be created based on Spring's `RestClient`, `WebClient` or `RestTemplate`, so we need to register it with a configuration class.
In this project, we have done this in a generic way with
- a custom annotation [`@HttpClient`](../src/main/java/de/samples/apicomparison/consumer/clients/rest/config/HttpClient.java)
  that we can add to the client interface
- a custom annotation [`@EnableHttpClients`](../src/main/java/de/samples/apicomparison/consumer/clients/rest/config/EnableHttpClients.java)
  that will automatically lead to initializing and registering all `@HttpClient`s within the Spring context based on the project's `WebClient`.

