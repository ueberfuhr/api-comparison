package de.samples.apicomparison.provider.boundary.graphql.mappers;

import de.samples.apicomparison.provider.boundary.graphql.model.QlBlogPostDto;
import de.samples.apicomparison.provider.boundary.graphql.model.QlBlogPostInputDto;
import de.samples.apicomparison.provider.domain.model.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QlBlogPostDtoMapper {

  @Mapping(target = "authorId", source = "author.id")
  @Mapping(target = "tags", source = "tags")
  QlBlogPostDto map(BlogPost source);

  BlogPost map(QlBlogPostInputDto source);

}
