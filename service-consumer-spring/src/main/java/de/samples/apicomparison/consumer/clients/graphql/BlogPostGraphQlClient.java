package de.samples.apicomparison.consumer.clients.graphql;

import de.samples.apicomparison.consumer.clients.graphql.model.QlBlogPostInputDto;
import de.samples.apicomparison.consumer.clients.rest.model.BlogPostDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Validated
@Component
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class BlogPostGraphQlClient {

  // https://docs.spring.io/spring-graphql/reference/client.html
  private final HttpGraphQlClient api;

  public Flux<BlogPostDto> findAll() {
    return this.api
      .documentName("findBlogPosts")
      .retrieve("findBlogPosts")
      .toEntityList(BlogPostDto.class)
      .flatMapMany(Flux::fromIterable);
  }

  public Mono<BlogPostDto> findById(@NotNull UUID id) {
    return this.api
      .documentName("findBlogPostById")
      .variable("id", id.toString())
      .retrieve("findBlogPostById")
      .toEntity(BlogPostDto.class);
  }

  public Mono<BlogPostDto> create(@Valid @NotNull QlBlogPostInputDto input) {
    return this.api
      .documentName("createBlogPost")
      .variable("input", input)
      .retrieve("createBlogPost")
      .toEntity(BlogPostDto.class);
  }

  public Mono<Void> delete(@NotNull UUID id) {
    return this.api
      .documentName("deleteBlogPost")
      .variable("id", id.toString())
      .execute()
      .then();
  }

}
