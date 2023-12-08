package de.samples.apicomparison.provider.boundary.graphql;

import de.samples.apicomparison.provider.boundary.graphql.mappers.QlAuthorDtoMapper;
import de.samples.apicomparison.provider.boundary.graphql.model.QlAuthorDto;
import de.samples.apicomparison.provider.boundary.graphql.model.QlBlogPostDto;
import de.samples.apicomparison.provider.domain.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class QlAuthorController {

  private final AuthorService service;
  private final QlAuthorDtoMapper mapper;

  @SchemaMapping(typeName = "BlogPost", field = "author")
  public QlAuthorDto findAssignee(QlBlogPostDto blogPost) {
    if(null == blogPost.getAuthorId()) {
      return null;
    }
    return this.mapper
      .map(
        this.service
          .findByIdOrThrow(blogPost.getAuthorId())
      );
  }

}
