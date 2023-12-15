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

### Service Provider

The service provider uses WebMVC to implement a REST API. There's an [OpenAPI](../service-provider/src/main/resources/static/openapi.yml)
describing our API. The code is divided into
- [Interfaces](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/rest/api) annotated with MVC metadata to map HTTP requests to Java methods
- [Classes](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/rest/impl) containing the implementation of the methods

In this project, we have integrated [SpringDoc](https://springdoc.org/), which is a separate project that is **not** under the umbrella of the Spring project. 
It provides the generation of [OpenAPI](http://localhost:8081/v3/api-docs) from the code during runtime and a [Swagger UI](http://localhost:8081/swagger-ui.html) 
to display both manually configured and rendered OpenAPI.

In this project, we have a customization that allows global setting of controller base paths, e.g. for implementing and differing multiple API versions:
- Annotation [@V1Api](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/rest/api/V1Api.java)
  to annotate a controller class
- An [API Type Configuration](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/rest/api/config/ApiTypeConfiguration.java) to 
  - add URL prefix `api/v1` to annotated controllers
  - add `api/v1` to the server URL within the generated OpenAPI (normally, this is assigned to the controllers request mapping)
- make this [configurable](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/rest/api/config/ApiTypeConfigurationProperties.java) 
  within `application.yml`
- unfortunately, there is a [problem with HATEOAS' `WebMvcLinkBuilder`](https://github.com/spring-projects/spring-hateoas/issues/1221)
  in combination with customized path prefixes, so we provide a custom `UriMappingResolver` that is based on `WebMvcLinkBuilder`, but
  is aware of configured path prefixes. We can inject this `UriMappingResolver` as a controller method's argument and use it for
  building links (esp. the `Location` header value).

So using this customization in a controller would look like this:

```java
@RestController
@RequestMapping("/blogposts")
@V1Api // --> "/api/v1/blogposts"
public class BlogPostsController {

  @GetMapping("/{id}")
  public BlogPostDto findById( 
          @PathVariable("id") UUID id 
  ) { 
      // ...
  }

  @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE )
  public ResponseEntity<BlogPostDto> create( 
          @RequestBody BlogPostDto post,
          // instead of WebMvcLinkBuilder, use this
          UriMappingResolver uriMappingResolver 
  ) {
      // ... save(post);
      return ResponseEntity
        .created(
          // instead of WebMvcLinkBuilder, use this
          uriMappingResolver.resolve(
            this.getClass(),
            c -> c.findById(post.getId())
          )
        )
        .body(post);
  }
    
}
```

### Service Consumer

For the consumer, we use the [HTTP Interface Client](https://docs.spring.io/spring-framework/reference/web/webflux-http-interface-client.html).
This has to be created based on Spring's `RestClient`, `WebClient` or `RestTemplate`, so we need to register it with a configuration class.
In this project, we have done this in a generic way with
- a custom annotation [`@HttpClient`](../service-consumer-spring/src/main/java/de/samples/apicomparison/consumer/clients/rest/config/HttpClient.java)
  that we can add to the client interface
- a custom annotation [`@EnableHttpClients`](../service-consumer-spring/src/main/java/de/samples/apicomparison/consumer/clients/rest/config/EnableHttpClients.java)
  that will automatically lead to initializing and registering all `@HttpClient`s within the Spring context based on the project's `WebClient`.

