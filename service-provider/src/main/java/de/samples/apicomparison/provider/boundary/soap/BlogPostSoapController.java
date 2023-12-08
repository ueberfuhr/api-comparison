package de.samples.apicomparison.provider.boundary.soap;

import de.samples.apicomparison.provider.boundary.soap.mappers.BlogPostSoapStubMapper;
import de.samples.apicomparison.provider.boundary.soap.stubs.*;
import de.samples.apicomparison.provider.domain.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class BlogPostSoapController implements BlogPostServiceInterface {

  private final BlogPostService service;
  private final BlogPostSoapStubMapper mapper;

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "findAllBlogPostsRequest"
  )
  @ResponsePayload
  @Override
  public FindAllBlogPostsResponse findAll(@RequestPayload FindAllBlogPostsRequest findAllInputPart) {
    final var result = new FindAllBlogPostsResponse();
    this.service
      .findAll()
      .map(this.mapper::map)
      .forEach(result.getBlogPosts()::add);
    return result;
  }

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "createBlogPostRequest"
  )
  @ResponsePayload
  @Override
  public void create(
    @RequestPayload
    CreateBlogPostRequest input
  ) {
    System.out.println("klappt");
  }

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "deleteBlogPostRequest"
  )
  @ResponsePayload
  @Override
  public void deleteById(
    @RequestPayload
    DeleteBlogPostRequest id
  ) {

  }
}
