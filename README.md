# API Comparison

This repository deals with different kinds of APIs (REST, GraphQL, SOAP, gRPC)
by explaining and comparing them, and by providing sample code for

- [a Service Provider (implemented with Spring Boot WebMVC)](./service-provider)
- [a Service Consumer (implemented with Spring Boot WebFlux)](./service-consumer-spring)
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
|                                 | **REST**                      | **GraphQL**                 | **SOAP**                      | **gRPC**                    |
|---------------------------------|-------------------------------|-----------------------------|-------------------------------|-----------------------------|
| **Description**                 | Use HTTP as designed          | Query Language for APIs     | XML-based Web Services        | High Performance RPC        |
| **API Style**                   | Resources-based               | RPC                         | RPC                           | RPC                         |
| **Top-Level API Elements**      | Resources and Operations      | Queries and Mutations       | Operations + Messages         | Services + Messages         |
| **HTTP Binding**                | URLs, methods, status codes   | single endpoint, `POST`, status `200` even for exceptions | single endpoint, `POST`, status `200` even for exceptions | HTTP/2 protobuf+streaming |
| **Alternative Protocols**       | _not possible_                | Websockets, RSockets        | SMTP, JMS                     | _not possible_              |
| **Media Types**                 | JSON (negotiable)             | JSON (pre-defined schema)   | XML/SOAP (pre-defined schema) | `application/grpc` (binary) |
| **API Description**             | OpenAPI                       | GraphQL-Schema              | WSDL + XSD                    | Proto File                  |
| **Tools** _(except Postman...)_ | Swagger (Editor, UI, Codegen) | GraphiQL UI                 | _nothing_                     | _nothing_                   | 
| **Advantages**                  | lightweight, uniformly, based on HTTP standards (compatible with Caches, Firewalls, Proxies, Gateways) | no over-/underfetching, hiding of complex architectures | availability of W3C standards (XML-Encryption, XML schema validation, XML-Security, XSL-T, ...) | binary format is fast to transfer |
| **Disadvantages**               | over-/underfetching (performance!)  | HTTP is just the transport protocol, no unique design, scalars and directives per platform, only JSON (e.g. no file uploads) | HTTP is just the transport protocol, no unique design | not readable as plaint text, parsing/serializing binary format is CPU-intensive, hardly any framework support |
| **When to use**                 | _(default choice)_   | flexible queries for complex hierarchies, providing multiple services with a single API | when W3C XML-based standards like XSL-T, XML encryption... are necessary, only S2S | high-performance data exchange, bi-directional streaming |
