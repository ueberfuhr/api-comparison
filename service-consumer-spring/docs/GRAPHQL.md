# Graph Query Language (GraphQL) - Spring Boot Service Consumer

The central helper class for the consumer is the
`org.springframework.graphql.client.HttpGraphQlClient` class, which helps
to build and execute the request and parse the response.
**This client is based on WebFlux**.

The requests can be pre-defined in [GraphQL Documents](../src/main/resources/graphql-documents),
which avoids building them in the Java Code. Instead, we can refer to the documents within the code
and replace placeholder variables during the invocation,

[BlogPost GraphQL Client](../src/main/java/de/samples/apicomparison/consumer/clients/graphql/BlogPostGraphQlClient.java)

There are [further clients](https://docs.spring.io/spring-graphql/reference/client.html)
for Websockets and RSocket too.

