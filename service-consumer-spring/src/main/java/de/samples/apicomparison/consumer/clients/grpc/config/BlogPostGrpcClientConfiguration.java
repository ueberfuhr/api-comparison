package de.samples.apicomparison.consumer.clients.grpc.config;

import de.samples.apicomparison.consumer.clients.grpc.BlogPostGrpClient;
import de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostGrpcClientConfiguration {

  @GrpcClient("blogposts")
  BlogPostServiceGrpc.BlogPostServiceStub blogPostClient;

  @Bean
  BlogPostGrpClient blogPostClient() {
    return new BlogPostGrpClient(blogPostClient);
  }

}
