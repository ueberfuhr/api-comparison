# gRPC - Spring Boot Service Provider

We use the [gRPC Ecosystem Spring Integration](https://github.com/grpc-ecosystem/grpc-spring)
(a third-party library) to get gRPC library integration into Spring Boot.
This includes running Netty to provide the service via HTTP/2 and configuring the platform
via `application.properties` or `application.yml`.

To implement a gRPC service provider, we need to do the following steps:

- declare a dependency to the [API Stubs](../../api-stubs/api-stubs-grpc)
- implement the [Blog Post Service Provider](../src/main/java/de/samples/apicomparison/provider/boundary/grpc/BlogPostGrpcController.java)
- configure the server port within the [`application.yml`](../src/main/resources/application.yml)
