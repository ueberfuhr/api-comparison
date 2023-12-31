package de.samples.apicomparison.consumer.clients.grpc.config;

import de.samples.apicomparison.consumer.clients.grpc.BlogPostGrpcClient;
import de.samples.apicomparison.stubs.grpc.BlogPostServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostGrpcClientConfiguration {

  @GrpcClient("blogposts")
  BlogPostServiceGrpc.BlogPostServiceStub blogPostClient;

  @Bean
  BlogPostGrpcClient blogPostClient() {
    return new BlogPostGrpcClient(blogPostClient);
  }

}
