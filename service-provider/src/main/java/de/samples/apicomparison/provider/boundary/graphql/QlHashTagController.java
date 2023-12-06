package de.samples.apicomparison.provider.boundary.graphql;

import de.samples.apicomparison.provider.boundary.graphql.mappers.HashTagMapper;
import de.samples.apicomparison.provider.boundary.graphql.model.QlBlogPostDto;
import de.samples.apicomparison.provider.boundary.graphql.model.QlHashTagDto;
import de.samples.apicomparison.provider.domain.HashTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class QlHashTagController {

  private final HashTagService service;
  private final HashTagMapper mapper;

  @SchemaMapping(typeName = "BlogPost", field = "tags")
  public Stream<QlHashTagDto> findHashTags(QlBlogPostDto blogPost) {
    final var tags = blogPost.getTags();
    if (null == tags || tags.isEmpty()) {
      return Stream.empty();
    }
    return this.service
      .findAllByNamesWithDefaults(tags)
      .map(this.mapper::map);
  }

}
