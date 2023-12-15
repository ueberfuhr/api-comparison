# Representational State Transfer (REST) - Spring Boot Service Provider

The service provider uses WebMVC to implement a REST API. There's an [OpenAPI](../src/main/resources/static/openapi.yml)
describing our API. The code is divided into
- [Interfaces](../src/main/java/de/samples/apicomparison/provider/boundary/rest/api) annotated with MVC metadata to map HTTP requests to Java methods
- [Classes](../src/main/java/de/samples/apicomparison/provider/boundary/rest/impl) containing the implementation of the methods

In this project, we have integrated [SpringDoc](https://springdoc.org/), which is a separate project that is **not** under the umbrella of the Spring project.
It provides the generation of [OpenAPI](http://localhost:8081/v3/api-docs) from the code during runtime and a [Swagger UI](http://localhost:8081/swagger-ui.html)
to display both manually configured and rendered OpenAPI.

In this project, we have a customization that allows global setting of controller base paths, e.g. for implementing and differing multiple API versions:
- Annotation [@V1Api](../src/main/java/de/samples/apicomparison/provider/boundary/rest/api/V1Api.java)
  to annotate a controller class
- An [API Type Configuration](../src/main/java/de/samples/apicomparison/provider/boundary/rest/api/config/ApiTypeConfiguration.java) to
  - add URL prefix `api/v1` to annotated controllers
  - add `api/v1` to the server URL within the generated OpenAPI (normally, this is assigned to the controllers request mapping)
- make this [configurable](../src/main/java/de/samples/apicomparison/provider/boundary/rest/api/config/ApiTypeConfigurationProperties.java)
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
