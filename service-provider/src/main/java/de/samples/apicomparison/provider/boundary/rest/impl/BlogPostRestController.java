package de.samples.apicomparison.provider.boundary.rest.impl;

import de.samples.apicomparison.provider.boundary.rest.api.BlogPostRestApi;
import de.samples.apicomparison.provider.boundary.rest.api.model.BlogPostDto;
import de.samples.apicomparison.provider.boundary.rest.impl.mappers.BlogPostDtoMapper;
import de.samples.apicomparison.provider.domain.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.UUID;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class BlogPostRestController implements BlogPostRestApi {

  private final BlogPostService service;
  private final BlogPostDtoMapper mapper;

  @Override
  public Stream<BlogPostDto> findAll(String authorName) {
    return (
      authorName != null && !authorName.isEmpty()
        ? this.service.findAllByAuthor(authorName)
        : this.service.findAll()
    )
      .map(this.mapper::map);
  }

  @Override
  public BlogPostDto findById(UUID id) {
    return this.mapper
      .map(
        this.service
          .findByIdOrThrow(id)
      );
  }

  @Override
  public void save(BlogPostDto post) {
    if (null != post.getId()) {
      final var postToUpdate = this.service.findByIdOrThrow(post.getId());
      this.mapper.copy(post, postToUpdate);
      this.service.update(postToUpdate);
      this.mapper.copy(postToUpdate, post);
    } else {
      final var mappedPost = this.mapper.map(post);
      this.service.create(mappedPost);
      this.mapper.copy(mappedPost, post);
    }
  }

  @Override
  public void delete(UUID id) {
    this.service
      .deleteById(id);
  }
}
