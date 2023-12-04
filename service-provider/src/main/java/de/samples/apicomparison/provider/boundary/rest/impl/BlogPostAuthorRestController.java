package de.samples.apicomparison.provider.boundary.rest.impl;

import de.samples.apicomparison.provider.boundary.rest.api.BlogPostAuthorRestApi;
import de.samples.apicomparison.provider.boundary.rest.api.model.AuthorDto;
import de.samples.apicomparison.provider.boundary.rest.impl.mappers.AuthorDtoMapper;
import de.samples.apicomparison.provider.domain.AuthorService;
import de.samples.apicomparison.provider.domain.BlogPostService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BlogPostAuthorRestController implements BlogPostAuthorRestApi {

  private final BlogPostService blogPostService;
  private final AuthorService authorService;
  private final AuthorDtoMapper mapper;

  @Override
  public AuthorDto getAuthor(UUID blogPostId) {
    final var author = this.blogPostService
      .findByIdOrThrow(blogPostId)
      .getAuthor();
    if (null == author) {
      throw new NotFoundException();
    }
    return this.mapper
      .map(author);
  }

  @Override
  public AssignResult assign(UUID blogPostId, UUID authorId) {
    final var blogPost = this.blogPostService
      .findByIdOrThrow(blogPostId);
    final AssignResult result =
      null == blogPost.getAuthor() ? AssignResult.CREATED : AssignResult.REPLACED;
    final var author = this.authorService
      .findById(authorId)
      .orElseThrow(ValidationException::new);
    blogPost.setAuthor(author);
    this.blogPostService.update(blogPost);
    return result;
  }

  @Override
  public void delete(UUID blogPostId) {
    final var blogPost = this.blogPostService
      .findByIdOrThrow(blogPostId);
    if (null == blogPost.getAuthor()) {
      throw new NotFoundException();
    }
    blogPost.setAuthor(null);
    this.blogPostService.update(blogPost);
  }
}
