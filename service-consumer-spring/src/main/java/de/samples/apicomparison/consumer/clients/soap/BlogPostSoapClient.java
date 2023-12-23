package de.samples.apicomparison.consumer.clients.soap;

import de.samples.apicomparison.stubs.soap.messages.*;
import de.samples.apicomparison.stubs.soap.model.BlogPost;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Validated
@Component
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class BlogPostSoapClient {

  private final HttpSoapClient client;

  public Flux<BlogPost> findAll() {
    final var request = new FindAllBlogPostsRequest();
    return this.client
      .call(request, FindAllBlogPostsResponse.class)
      .map(FindAllBlogPostsResponse::getBlogPosts)
      .flatMapMany(Flux::fromIterable);
  }

  public Mono<BlogPost> create(@NotNull BlogPostInput input) {
    final var request = new CreateBlogPostRequest();
    request.setInput(input);
    return this.client
      .call(request, CreateBlogPostResponse.class)
      .map(CreateBlogPostResponse::getBlogPost);
  }

  public Mono<Void> delete(@NotNull UUID uuid) {
    final var request = new DeleteBlogPostRequest();
    request.setId(uuid.toString());
    return this.client
      .call(request, DeleteBlogPostResponse.class)
      .then();
  }

  public Mono<Optional<BlogPost>> findById(@NotNull UUID uuid) {
    final var request = new FindBlogPostByIdRequest();
    request.setId(uuid.toString());
    return this.client
      .call(request, FindBlogPostByIdResponse.class)
      .map(FindBlogPostByIdResponse::getBlogPost)
      .map(Optional::ofNullable);
  }
}
