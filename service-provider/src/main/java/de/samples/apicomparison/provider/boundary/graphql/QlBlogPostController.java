package de.samples.apicomparison.provider.boundary.graphql;

import de.samples.apicomparison.provider.boundary.graphql.mappers.QlBlogPostDtoMapper;
import de.samples.apicomparison.provider.boundary.graphql.model.QlBlogPostDto;
import de.samples.apicomparison.provider.boundary.graphql.model.QlBlogPostInputDto;
import de.samples.apicomparison.provider.domain.BlogPostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class QlBlogPostController {

  private final BlogPostService service;
  private final QlBlogPostDtoMapper mapper;

  @QueryMapping("findBlogPosts")
  public Stream<QlBlogPostDto> findAll() {
    return this.service
      .findAll()
      .map(this.mapper::map);
  }

  @QueryMapping("findBlogPostsByAuthor")
  public Stream<QlBlogPostDto> findAll(@NotEmpty @Argument String name) {
    return this.service
      .findAllByAuthor(name)
      .map(this.mapper::map);
  }

  @QueryMapping("findBlogPostById")
  public QlBlogPostDto findById(@Argument UUID id) {
    return this.mapper
      .map(
        this.service.findByIdOrThrow(id)
      );
  }

  @MutationMapping("createBlogPost")
  public QlBlogPostDto create(@Valid @Argument QlBlogPostInputDto input) {
    var post = this.mapper.map(input);
    this.service.create(post);
    return this.mapper.map(post);
  }

  @MutationMapping("deleteBlogPost")
  public void delete(@Argument UUID id) {
    this.service.deleteById(id);
  }

}
