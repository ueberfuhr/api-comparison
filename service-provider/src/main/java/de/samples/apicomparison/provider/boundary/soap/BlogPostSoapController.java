package de.samples.apicomparison.provider.boundary.soap;

import de.samples.apicomparison.provider.boundary.soap.mappers.BlogPostSoapStubMapper;
import de.samples.apicomparison.provider.domain.AuthorService;
import de.samples.apicomparison.provider.domain.BlogPostService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import de.samples.apicomparison.stubs.soap.messages.*;
import de.samples.apicomparison.stubs.soap.service.BlogPostServiceInterface;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.UUID;

@Endpoint
@RequiredArgsConstructor
public class BlogPostSoapController implements BlogPostServiceInterface {

  private final BlogPostService service;
  private final AuthorService authorService;
  private final BlogPostSoapStubMapper mapper;

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "findAllBlogPostsRequest"
  )
  @ResponsePayload
  @Override
  public FindAllBlogPostsResponse findAll(
    @RequestPayload
    FindAllBlogPostsRequest
      request
  ) {
    final var response = new FindAllBlogPostsResponse();
    this.service
      .findAll()
      .map(this.mapper::map)
      .forEach(response.getBlogPosts()::add);
    return response;
  }

  private UUID parseId(String id) {
    if (null == id) {
      return null;
    }
    try {
      return UUID.fromString(id);
    } catch (IllegalArgumentException e) {
      // TODO we could also throw any exception for a bad request
      throw new ValidationException();
    }

  }

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "createBlogPostRequest"
  )
  @ResponsePayload
  @Override
  public CreateBlogPostResponse create(
    @RequestPayload
    CreateBlogPostRequest request
  ) {
    final var input = request.getInput();
    final var newBlogPost = this.mapper.map(input);
    final UUID authorId = this.parseId(input.getAuthor());
    if (authorId != null) {
      final var author = this.authorService.findByIdOrThrow(authorId);
      newBlogPost.setAuthor(author);
    }
    newBlogPost.setId(UUID.randomUUID());
    this.service.create(newBlogPost);
    final var response = new CreateBlogPostResponse();
    response.setBlogPost(this.mapper.map(newBlogPost));
    return response;
  }

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "deleteBlogPostRequest"
  )
  @ResponsePayload
  @Override
  public DeleteBlogPostResponse deleteById(
    @RequestPayload
    DeleteBlogPostRequest deleteInputPart
  ) {
    final var uuid = this.parseId(deleteInputPart.getId());
    final var response = new DeleteBlogPostResponse();
    try {
      this.service.deleteById(uuid);
      response.setStatus(DeleteBlogPostResponse.DeleteOperationStatus.DELETED);
    } catch (NotFoundException e) {
      response.setStatus(DeleteBlogPostResponse.DeleteOperationStatus.NOT_FOUND);
    }
    return response;
  }

  @PayloadRoot(
    namespace = "http://samples.de/spring/soap/blog/messages",
    localPart = "findBlogPostByIdRequest"
  )
  @ResponsePayload
  @Override
  public FindBlogPostByIdResponse findById(
    @RequestPayload
    FindBlogPostByIdRequest findByIdInputPart
  ) {
    final var uuid = this.parseId(findByIdInputPart.getId());
    final var response = new FindBlogPostByIdResponse();
    this.service.findById(uuid)
      .map(this.mapper::map)
      .ifPresent(response::setBlogPost);
    return response;
  }

}
