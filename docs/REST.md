# Representational State Transfer (REST)

[Presentation (German Language, PDF)](rest/REST.pdf)

## Basics

REST is an architectural style for providing standards between computer systems on the web,
making it easier for systems to communicate with each other. It is fully based on HTTP -
more precisely, it means using HTTP uniformly and according to its design. The "inventor" is 
[Roy Thomas Fielding](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm),
who also participated in the specification process of HTTP itself.

The basic rules are

- use resource-based URLs (nouns)
- use HTTP verbs semantically correct to map the operations (typically CRUD)
- comply with the requirements for idempotence
- make content negotiation binding

And there are further guidelines like the [Zalando Guidelines](https://opensource.zalando.com/restful-api-guidelines/)
that can help beginners by providing more detailed descriptions and giving straighter rules based on best practices.

There are some standards that complement the ecosystem:
- [OpenAPI](https://www.openapis.org/) to describe HTTP based APIs
- [Swagger Tools](https://swagger.io/) for editing OpenAPI and providing a UI and code generators
- [Problem Details (RFC-9457)](https://datatracker.ietf.org/doc/rfc9457/) for unique error messages
- [Hypermedia APIs with HAL](https://www.innoq.com/en/articles/2020/12/rest-apis-with-hal/)

[BlogPostService sample requests](../sample-requests/rest)

## REST with Spring Boot

REST services are provided by both Spring [WebMVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html) and 
[WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html) (see [Reactive Stack with Spring](https://spring.io/reactive)). 

- [Service Provider](../service-provider/docs/REST.md)
- [Service Consumer](../service-consumer-spring/docs/REST.md)
