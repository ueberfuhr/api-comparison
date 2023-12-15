# Graph Query Language (GraphQL)

## Basics

[GraphQL](https://graphql.org/) is a query language for APIs and a runtime for fulfilling those queries 
with your existing data. GraphQL provides a complete and understandable description of the data in the 
API, gives clients the power to ask for exactly what they need and nothing more, makes it easier to 
evolve APIs over time, and enables powerful developer tools.

Requests are based on HTTP, Websockets or RSocket. Exchange format is JSON, where the request body is
a JSON object with a single query field of type string that contains the GraphQL query syntax. The result
is a complex JSON object.

[BlogPostService sample requests](../sample-requests/graphql)

The API is specified within a schema, where _queries_ and _mutations_ and corresponding data types are defined.
For custom simple data types, we can define _scalars_, which we must implement in the code
(some kind of converter logic for serialization and deserialization). Dependent from the framework or programming
language, there are several dependencies providing pre-defined scalars.

[BlogPostService GraphQL Schema](../service-provider/src/main/resources/graphql/blog.graphqls)

The schema can be rendered by [GraphiQL](http://localhost:8081/graphiql) to provide the user a UI for testing the API.

## GraphQL with Spring Boot

Spring has [GraphQL-Support](https://spring.io/projects/spring-graphql), so we only need a starter dependency
to get it integrated.

- [Service Provider](../service-provider/docs/GRAPHQL.md)
- [Service Consumer](../service-consumer-spring/docs/GRAPHQL.md)
