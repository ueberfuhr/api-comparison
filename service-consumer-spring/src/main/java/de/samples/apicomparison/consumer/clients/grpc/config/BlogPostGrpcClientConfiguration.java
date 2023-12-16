package de.samples.apicomparison.consumer.clients.grpc.config;

import de.samples.apicomparison.consumer.clients.grpc.BlogPostGrpClient;
import de.samples.apicomparison.consumer.clients.grpc.stub.BlogPostServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogPostGrpcClientConfiguration {

  @Bean
  BlogPostGrpClient blogPostClient(
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @GrpcClient("blogposts")
    BlogPostServiceGrpc.BlogPostServiceStub blogPostClient
  ) {
    return new BlogPostGrpClient(blogPostClient);
  }

}
