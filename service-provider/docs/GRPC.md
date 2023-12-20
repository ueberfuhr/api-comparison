# gRPC - Spring Boot Service Provider

We use the [gRPC Ecosystem Spring Integration](https://github.com/grpc-ecosystem/grpc-spring)
(a third-party library) to get gRPC library integration into Spring Boot.
This includes running Netty to provide the service via HTTP/2 and configuring the platform
via `application.properties` or `application.yml`.

To implement a gRPC service provider, we need to do the following steps:

- specify the API within a [proto file](../src/main/resources/grpc/blogposts.proto)
  (by default, placed under `src/main/proto`)
- configure the [`pom.xml`](../pom.xml) to invoke the platform-dependent proto compiler
  - we could do this automatically within the CI pipeline
  - in this project, we generate stubs into 
    [`src/main/java`](../src/main/java/de/samples/apicomparison/provider/boundary/grpc/stub)
    - we do this manually and manage the sources within Git
- unfortunately, there is a [bug](https://github.com/grpc/grpc-java/issues/9179) that leeds to
  compiler errors within Spring Boot 3 projects, so when generating automatically, we would prefer
  doing this within a separate project with old Java EE as a dependency. In this project, we
  fix this bug by manually fixing the wrong import (which needs to be done after each generation)
- implement the [Blog Post Service Provider](../src/main/java/de/samples/apicomparison/provider/boundary/grpc/BlogPostGrpcController.java)
- configure the server port within the [`application.yml`](../src/main/resources/application.yml)
