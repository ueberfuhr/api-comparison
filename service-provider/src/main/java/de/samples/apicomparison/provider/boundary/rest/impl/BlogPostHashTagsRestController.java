package de.samples.apicomparison.provider.boundary.rest.impl;

import de.samples.apicomparison.provider.boundary.rest.api.BlogPostHashTagsRestApi;
import de.samples.apicomparison.provider.boundary.rest.api.model.HashTagDto;
import de.samples.apicomparison.provider.boundary.rest.impl.mappers.HashTagDtoMapper;
import de.samples.apicomparison.provider.domain.BlogPostService;
import de.samples.apicomparison.provider.domain.HashTagService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import de.samples.apicomparison.provider.domain.model.HashTag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class BlogPostHashTagsRestController implements BlogPostHashTagsRestApi {

  private final BlogPostService blogPostService;
  private final HashTagService hashTagService;
  private final HashTagDtoMapper mapper;

  private static HashTag defaultHashTag(String name) {
    return HashTag.builder().name(name).build();
  }


  @Override
  public Stream<HashTagDto> findAll(UUID blogPostId) {
    final var post = this.blogPostService
      .findByIdOrThrow(blogPostId);
    final var tags = post.getTags();
    final var existingTagsByName =
      tags.size() > 1
        ? this.hashTagService
        .findAllByNames(tags)
        .collect(Collectors.toMap(HashTag::getName, Function.identity()))
        : Collections.<String, HashTag>emptyMap();
    return tags.stream()
      .map(
        name -> existingTagsByName.getOrDefault(
          name,
          defaultHashTag(name)
        )
      )
      .map(this.mapper::map);
  }

  @Override
  public HashTagDto findByName(UUID blogPostId, String name) {
    final var post = this.blogPostService
      .findByIdOrThrow(blogPostId);
    if (!post.getTags().contains(name)) {
      throw new NotFoundException();
    }
    return this.mapper
      .map(
        this.hashTagService
          .findByName(name)
          .orElseGet(() -> defaultHashTag(name))
      );
  }

  @Override
  public AssignResult assign(UUID blogPostId, String name) {
    final var post = this.blogPostService
      .findByIdOrThrow(blogPostId);
    if (post.getTags().contains(name)) {
      return AssignResult.REPLACED;
    }
    post.getTags().add(name);
    this.blogPostService.update(post);
    return AssignResult.CREATED;
  }

  @Override
  public void delete(UUID blogPostId, String name) {
    final var post = this.blogPostService
      .findByIdOrThrow(blogPostId);
    if (!post.getTags().contains(name)) {
      throw new NotFoundException();
    }
    post.getTags().remove(name);
    this.blogPostService.update(post);
  }
}
