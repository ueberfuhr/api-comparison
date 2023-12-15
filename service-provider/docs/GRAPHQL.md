# Graph Query Language (GraphQL) - Spring Boot Service Provider

Service providers can be implemented based on HTTP with bot Spring WebMVC and WebFlux.
There are [further implementations](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web.graphql.transports)
for WebSockets and RSocket.

So we need to do the following steps:
- Specify the API with a [GraphQL Schema](../src/main/resources/graphql/blog.graphqls)
- Implement [controllers](../src/main/java/de/samples/apicomparison/provider/boundary/graphql) annotated with GraphQL annotations.
- Optionally, implement [scalars](../src/main/java/de/samples/apicomparison/provider/boundary/graphql/scalars).
