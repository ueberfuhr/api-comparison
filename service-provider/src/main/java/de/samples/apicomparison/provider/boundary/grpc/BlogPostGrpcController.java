package de.samples.apicomparison.provider.boundary.grpc;

import com.google.protobuf.Empty;
import de.samples.apicomparison.provider.boundary.grpc.stub.BlogPost;
import de.samples.apicomparison.provider.boundary.grpc.stub.BlogPostInput;
import de.samples.apicomparison.provider.boundary.grpc.stub.BlogPostServiceGrpc;
import de.samples.apicomparison.provider.boundary.grpc.stub.ListOfBlogPosts;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class BlogPostGrpcController extends BlogPostServiceGrpc.BlogPostServiceImplBase {

  @Override
  public void findAllBlogPosts(Empty request, StreamObserver<ListOfBlogPosts> responseObserver) {
    super.findAllBlogPosts(request, responseObserver);
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
