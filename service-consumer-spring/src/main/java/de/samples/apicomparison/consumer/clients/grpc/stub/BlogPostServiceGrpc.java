package de.samples.apicomparison.consumer.clients.grpc.stub;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@jakarta.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: blogposts.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BlogPostServiceGrpc {

  private BlogPostServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "BlogPostService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts> getFindAllBlogPostsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllBlogPosts",
      requestType = com.google.protobuf.Empty.class,
      responseType = de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts> getFindAllBlogPostsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts> getFindAllBlogPostsMethod;
    if ((getFindAllBlogPostsMethod = BlogPostServiceGrpc.getFindAllBlogPostsMethod) == null) {
      synchronized (BlogPostServiceGrpc.class) {
        if ((getFindAllBlogPostsMethod = BlogPostServiceGrpc.getFindAllBlogPostsMethod) == null) {
          BlogPostServiceGrpc.getFindAllBlogPostsMethod = getFindAllBlogPostsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllBlogPosts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts.getDefaultInstance()))
              .setSchemaDescriptor(new BlogPostServiceMethodDescriptorSupplier("FindAllBlogPosts"))
              .build();
        }
      }
    }
    return getFindAllBlogPostsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getFindAllBlogPostsStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindAllBlogPostsStream",
      requestType = com.google.protobuf.Empty.class,
      responseType = de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getFindAllBlogPostsStreamMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getFindAllBlogPostsStreamMethod;
    if ((getFindAllBlogPostsStreamMethod = BlogPostServiceGrpc.getFindAllBlogPostsStreamMethod) == null) {
      synchronized (BlogPostServiceGrpc.class) {
        if ((getFindAllBlogPostsStreamMethod = BlogPostServiceGrpc.getFindAllBlogPostsStreamMethod) == null) {
          BlogPostServiceGrpc.getFindAllBlogPostsStreamMethod = getFindAllBlogPostsStreamMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindAllBlogPostsStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost.getDefaultInstance()))
              .setSchemaDescriptor(new BlogPostServiceMethodDescriptorSupplier("FindAllBlogPostsStream"))
              .build();
        }
      }
    }
    return getFindAllBlogPostsStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput,
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getCreateBlogPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBlogPost",
      requestType = de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.class,
      responseType = de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput,
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getCreateBlogPostMethod() {
    io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getCreateBlogPostMethod;
    if ((getCreateBlogPostMethod = BlogPostServiceGrpc.getCreateBlogPostMethod) == null) {
      synchronized (BlogPostServiceGrpc.class) {
        if ((getCreateBlogPostMethod = BlogPostServiceGrpc.getCreateBlogPostMethod) == null) {
          BlogPostServiceGrpc.getCreateBlogPostMethod = getCreateBlogPostMethod =
              io.grpc.MethodDescriptor.<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBlogPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost.getDefaultInstance()))
              .setSchemaDescriptor(new BlogPostServiceMethodDescriptorSupplier("CreateBlogPost"))
              .build();
        }
      }
    }
    return getCreateBlogPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput,
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getCreateBlogPostStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBlogPostStream",
      requestType = de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.class,
      responseType = de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput,
      de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getCreateBlogPostStreamMethod() {
    io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> getCreateBlogPostStreamMethod;
    if ((getCreateBlogPostStreamMethod = BlogPostServiceGrpc.getCreateBlogPostStreamMethod) == null) {
      synchronized (BlogPostServiceGrpc.class) {
        if ((getCreateBlogPostStreamMethod = BlogPostServiceGrpc.getCreateBlogPostStreamMethod) == null) {
          BlogPostServiceGrpc.getCreateBlogPostStreamMethod = getCreateBlogPostStreamMethod =
              io.grpc.MethodDescriptor.<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput, de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBlogPostStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost.getDefaultInstance()))
              .setSchemaDescriptor(new BlogPostServiceMethodDescriptorSupplier("CreateBlogPostStream"))
              .build();
        }
      }
    }
    return getCreateBlogPostStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.UUID,
      com.google.protobuf.Empty> getDeleteBlogPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBlogPost",
      requestType = de.samples.apicomparison.consumer.clients.grpc.stub.UUID.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.UUID,
      com.google.protobuf.Empty> getDeleteBlogPostMethod() {
    io.grpc.MethodDescriptor<de.samples.apicomparison.consumer.clients.grpc.stub.UUID, com.google.protobuf.Empty> getDeleteBlogPostMethod;
    if ((getDeleteBlogPostMethod = BlogPostServiceGrpc.getDeleteBlogPostMethod) == null) {
      synchronized (BlogPostServiceGrpc.class) {
        if ((getDeleteBlogPostMethod = BlogPostServiceGrpc.getDeleteBlogPostMethod) == null) {
          BlogPostServiceGrpc.getDeleteBlogPostMethod = getDeleteBlogPostMethod =
              io.grpc.MethodDescriptor.<de.samples.apicomparison.consumer.clients.grpc.stub.UUID, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBlogPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  de.samples.apicomparison.consumer.clients.grpc.stub.UUID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BlogPostServiceMethodDescriptorSupplier("DeleteBlogPost"))
              .build();
        }
      }
    }
    return getDeleteBlogPostMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlogPostServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogPostServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogPostServiceStub>() {
        @java.lang.Override
        public BlogPostServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogPostServiceStub(channel, callOptions);
        }
      };
    return BlogPostServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlogPostServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogPostServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogPostServiceBlockingStub>() {
        @java.lang.Override
        public BlogPostServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogPostServiceBlockingStub(channel, callOptions);
        }
      };
    return BlogPostServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlogPostServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogPostServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogPostServiceFutureStub>() {
        @java.lang.Override
        public BlogPostServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogPostServiceFutureStub(channel, callOptions);
        }
      };
    return BlogPostServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findAllBlogPosts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllBlogPostsMethod(), responseObserver);
    }

    /**
     */
    default void findAllBlogPostsStream(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindAllBlogPostsStreamMethod(), responseObserver);
    }

    /**
     */
    default void createBlogPost(de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput request,
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBlogPostMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput> createBlogPostStream(
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCreateBlogPostStreamMethod(), responseObserver);
    }

    /**
     */
    default void deleteBlogPost(de.samples.apicomparison.consumer.clients.grpc.stub.UUID request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBlogPostMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BlogPostService.
   */
  public static abstract class BlogPostServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BlogPostServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BlogPostService.
   */
  public static final class BlogPostServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BlogPostServiceStub> {
    private BlogPostServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogPostServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogPostServiceStub(channel, callOptions);
    }

    /**
     */
    public void findAllBlogPosts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindAllBlogPostsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void findAllBlogPostsStream(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFindAllBlogPostsStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createBlogPost(de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput request,
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBlogPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput> createBlogPostStream(
        io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCreateBlogPostStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void deleteBlogPost(de.samples.apicomparison.consumer.clients.grpc.stub.UUID request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBlogPostMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BlogPostService.
   */
  public static final class BlogPostServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BlogPostServiceBlockingStub> {
    private BlogPostServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogPostServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogPostServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts findAllBlogPosts(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindAllBlogPostsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> findAllBlogPostsStream(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFindAllBlogPostsStreamMethod(), getCallOptions(), request);
    }

    /**
     */
    public de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost createBlogPost(de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBlogPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty deleteBlogPost(de.samples.apicomparison.consumer.clients.grpc.stub.UUID request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBlogPostMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BlogPostService.
   */
  public static final class BlogPostServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BlogPostServiceFutureStub> {
    private BlogPostServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogPostServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogPostServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts> findAllBlogPosts(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindAllBlogPostsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost> createBlogPost(
        de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBlogPostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBlogPost(
        de.samples.apicomparison.consumer.clients.grpc.stub.UUID request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBlogPostMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_ALL_BLOG_POSTS = 0;
  private static final int METHODID_FIND_ALL_BLOG_POSTS_STREAM = 1;
  private static final int METHODID_CREATE_BLOG_POST = 2;
  private static final int METHODID_DELETE_BLOG_POST = 3;
  private static final int METHODID_CREATE_BLOG_POST_STREAM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_ALL_BLOG_POSTS:
          serviceImpl.findAllBlogPosts((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts>) responseObserver);
          break;
        case METHODID_FIND_ALL_BLOG_POSTS_STREAM:
          serviceImpl.findAllBlogPostsStream((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>) responseObserver);
          break;
        case METHODID_CREATE_BLOG_POST:
          serviceImpl.createBlogPost((de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput) request,
              (io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>) responseObserver);
          break;
        case METHODID_DELETE_BLOG_POST:
          serviceImpl.deleteBlogPost((de.samples.apicomparison.consumer.clients.grpc.stub.UUID) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BLOG_POST_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createBlogPostStream(
              (io.grpc.stub.StreamObserver<de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFindAllBlogPostsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              de.samples.apicomparison.consumer.clients.grpc.stub.ListOfBlogPosts>(
                service, METHODID_FIND_ALL_BLOG_POSTS)))
        .addMethod(
          getFindAllBlogPostsStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>(
                service, METHODID_FIND_ALL_BLOG_POSTS_STREAM)))
        .addMethod(
          getCreateBlogPostMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput,
              de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>(
                service, METHODID_CREATE_BLOG_POST)))
        .addMethod(
          getCreateBlogPostStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostInput,
              de.samples.apicomparison.consumer.clients.grpc.stub.BlogPost>(
                service, METHODID_CREATE_BLOG_POST_STREAM)))
        .addMethod(
          getDeleteBlogPostMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              de.samples.apicomparison.consumer.clients.grpc.stub.UUID,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_BLOG_POST)))
        .build();
  }

  private static abstract class BlogPostServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlogPostServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return de.samples.apicomparison.consumer.clients.grpc.stub.Blogposts.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlogPostService");
    }
  }

  private static final class BlogPostServiceFileDescriptorSupplier
      extends BlogPostServiceBaseDescriptorSupplier {
    BlogPostServiceFileDescriptorSupplier() {}
  }

  private static final class BlogPostServiceMethodDescriptorSupplier
      extends BlogPostServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BlogPostServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlogPostServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlogPostServiceFileDescriptorSupplier())
              .addMethod(getFindAllBlogPostsMethod())
              .addMethod(getFindAllBlogPostsStreamMethod())
              .addMethod(getCreateBlogPostMethod())
              .addMethod(getCreateBlogPostStreamMethod())
              .addMethod(getDeleteBlogPostMethod())
              .build();
        }
      }
    }
    return result;
  }
}
