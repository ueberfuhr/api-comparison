package de.samples.apicomparison.consumer.clients.grpc;

import com.google.protobuf.Empty;
import de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost;
import de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput;
import de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostServiceGrpc;
import de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts;
import de.samples.apicomparison.consumer.clients.rest.model.BlogPostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class BlogPostGrpClient {

  private final BlogPostServiceGrpc.BlogPostServiceStub blogPostClient;

  public Flux<BlogPost> findAll() {
    final var bridge = StreamObserverUtility.
      createStreamObserverFluxPair(ListOfBlogPosts::getBlogPostList);
    this.blogPostClient
      .findAllBlogPosts(
        Empty.newBuilder().build(),
        bridge.streamObserver()
      );
    return bridge.flux()
      .flatMap(Flux::fromIterable);
  }

  public Mono<BlogPost> create(@Valid @RequestBody BlogPostDto post) {
    final var bridge = StreamObserverUtility.
      <BlogPost>createStreamObserverFluxPair();
    this.blogPostClient
      .createBlogPost(
        BlogPostInput
          .newBuilder()
          .setTitle(post.getTitle())
          .setContent(post.getContent())
          .build(),
        bridge.streamObserver()
      );
    return bridge
      .flux()
      .single();
  }

  public Mono<Void> delete(@PathVariable UUID id) {
    final var bridge = StreamObserverUtility.
      <Empty, Void>createStreamObserverFluxPair(_ -> null);
    this.blogPostClient
      .deleteBlogPost(
        de.samples.apicomparison.consumer.clients.grpc.stub.UUID
          .newBuilder()
          .setValue(id.toString())
          .build(),
        bridge.streamObserver()
      );
    return bridge
      .flux()
      .single();
  }

}
