# gRPC - Spring Boot Consumer Provider

We use the [gRPC Ecosystem Spring Integration](https://github.com/grpc-ecosystem/grpc-spring)
(a third-party library) to get gRPC library integration into Spring Boot.
This includes opening a Channel (gRPC specifiy type) to the service provider and configuring the
platform via `application.properties` or `application.yml`.

To implement a gRPC service consumer, we need to do the following steps:

- declare a dependency to the [API Stubs](../../api-stubs/api-stubs-grpc)
- implement the [Blog Post Service Consumer](../src/main/java/de/samples/apicomparison/consumer/clients/grpc/BlogPostGrpcClient.java)
- configure the server connection within the [`application.yml`](../src/main/resources/application.yml)
- configure the Blog Post Service Consumer to be available within the context
  (see [`BlogPostGrpcClientConfiguration`](../src/main/java/de/samples/apicomparison/consumer/clients/grpc/config/BlogPostGrpcClientConfiguration.java))
