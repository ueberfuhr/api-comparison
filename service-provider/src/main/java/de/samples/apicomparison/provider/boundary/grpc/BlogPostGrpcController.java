package de.samples.apicomparison.provider.boundary.grpc;

import com.google.protobuf.Empty;
import de.samples.apicomparison.provider.boundary.grpc.mappers.BlogPostMapper;
import de.samples.apicomparison.provider.boundary.grpc.stub.BlogPost;
import de.samples.apicomparison.provider.boundary.grpc.stub.BlogPostInput;
import de.samples.apicomparison.provider.boundary.grpc.stub.BlogPostServiceGrpc;
import de.samples.apicomparison.provider.boundary.grpc.stub.ListOfBlogPosts;
import de.samples.apicomparison.provider.domain.BlogPostService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@RequiredArgsConstructor
public class BlogPostGrpcController extends BlogPostServiceGrpc.BlogPostServiceImplBase {

  private final BlogPostService service;
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
    super.findAllBlogPostsStream(request, responseObserver);
  }

  @Override
  public void createBlogPost(BlogPostInput request, StreamObserver<BlogPost> responseObserver) {
    super.createBlogPost(request, responseObserver);
  }

  @Override
  public StreamObserver<BlogPostInput> createBlogPostStream(StreamObserver<BlogPost> responseObserver) {
    return super.createBlogPostStream(responseObserver);
  }
}
