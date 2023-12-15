# gRPC - Spring Boot Service Provider

We use a [third-party library](https://github.com/LogNet/grpc-spring-boot-starter) to get gRPC library
integration into Spring Boot. This includes a separate Netty Server that by default runs on port `6565`,
but is configured here with the +1-policy to `6566`.
