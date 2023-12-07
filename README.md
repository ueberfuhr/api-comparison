# API Comparison

This repository deals with different kinds of APIs (REST, GraphQL, SOAP, gRPC)
by explaining and comparing them, and by providing sample code for

- [a Service Provider (implemented with Spring Boot)](./service-provider)
- [a Service Consumer (implemented with Spring Boot)](./service-consumer-spring)
- a service consumer (implemented with Angular) - _t.b.d._

## Run the samples

We can run the samples as usual, and we can find further endpoints on a landing page:

- http://localhost:8081/ (Service Provider)
- http://localhost:8081/ (Service Consumer - Spring)
- http://localhost:4200/ (Service Consumer - Angular) - _t.b.d._

## Explore the API types

To find out more details about one kind of API, we can read the docs:

- [REST](./docs/REST.md)
- [GraphQL](./docs/GRAPHQL.md)
- [SOAP](./docs/SOAP.md)
- [gRPC](./docs/GRPC.md)

The table below shows a comparison between those types
|                             | **REST**                    | **GraphQL**                 | **SOAP**                      | **gRPC**                    |
|-----------------------------|-----------------------------|-----------------------------|-------------------------------|-----------------------------|
| **Description**             | Use HTTP as designed        | Query Language for APIs     | XML-based Web Services        | High Performance RPC        |
| **API Style**               | Resources-based             | RPC                         | RPC                           | RPC                         |
| **Top-Level API Elements**  | Resources and Operations    | Queries and Mutations       | Operations + Messages         | Services + Messages         |
| **HTTP Binding**            | URLs, methods, status codes | single endpoint, `POST`, status `200` even for eceptions
| **Alternative Protocols**   | _not possible_              | Websockets, RSockets       | SMTP, JMS                     | _not possible_              |
| **Media Types**             | JSON (negotiable)           | JSON (pre-defined schema)   | XML/SOAP (pre-defined schema) | `application/grpc` (binary) |
| 
Exceptions
Schema / Tools
Advantages
Disadvantages
When to use
