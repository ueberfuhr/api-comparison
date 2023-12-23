package de.samples.apicomparison.provider.boundary.grpc;

import com.google.protobuf.Empty;
import de.samples.apicomparison.provider.boundary.grpc.mappers.BlogPostMapper;
import de.samples.apicomparison.provider.domain.AuthorService;
import de.samples.apicomparison.provider.domain.BlogPostService;
import de.samples.apicomparison.stubs.grpc.BlogPost;
import de.samples.apicomparison.stubs.grpc.BlogPostInput;
import de.samples.apicomparison.stubs.grpc.BlogPostServiceGrpc;
import de.samples.apicomparison.stubs.grpc.ListOfBlogPosts;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class BlogPostGrpcController extends BlogPostServiceGrpc.BlogPostServiceImplBase {

  private final BlogPostService service;
  private final AuthorService authorService;
  private final BlogPostMapper mapper;

  @Override
  public void findAllBlogPosts(Empty request, StreamObserver<ListOfBlogPosts> responseObserver) {
    final var responseBuilder = ListOfBlogPosts.newBuilder();
    this.service.findAll()
      .map(this.mapper::map)
      .forEach(responseBuilder::addBlogPost);
    responseObserver.onNext(responseBuilder.build());
    responseObserver.onCompleted();
  }

  @Override
  public void findAllBlogPostsStream(Empty request, StreamObserver<BlogPost> responseObserver) {
    this.service.findAll()
      .map(this.mapper::map)
      .forEach(responseObserver::onNext);
    responseObserver.onCompleted();
  }

  @Override
  public void createBlogPost(BlogPostInput request, StreamObserver<BlogPost> responseObserver) {
    final var blogPost = createBlogPostFromInput(request);
    responseObserver.onNext(blogPost);
    responseObserver.onCompleted();
  }

  private BlogPost createBlogPostFromInput(BlogPostInput request) {
    final var blogPost = de.samples.apicomparison.provider.domain.model.BlogPost.builder()
      .title(request.getTitle())
      .content(request.getContent())
      .tags(request.getHashTagsList())
      .author(
        !request.getAuthorId().getValue().isEmpty()
          ? this.authorService.findByIdOrThrow(UUID.fromString(request.getAuthorId().getValue()))
          : null
      )
      .build();
    this.service.create(blogPost);
    return this.mapper.map(blogPost);
  }

  @Override
  public StreamObserver<BlogPostInput> createBlogPostStream(final StreamObserver<BlogPost> responseObserver) {
    return StreamObserverUtility.proxyStream(responseObserver, this::createBlogPostFromInput);
  }

  @Override
  public void deleteBlogPost(de.samples.apicomparison.stubs.grpc.UUID request, StreamObserver<Empty> responseObserver) {
    try {
      this.service.deleteById(UUID.fromString(request.getValue()));
    } finally {
      responseObserver.onNext(Empty.newBuilder().build());
      responseObserver.onCompleted();
    }
  }
}
