package de.samples.apicomparison.provider.boundary.rest.impl.mappers;

import de.samples.apicomparison.provider.boundary.rest.api.model.BlogPostDto;
import de.samples.apicomparison.provider.domain.model.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BlogPostDtoMapper {

  BlogPostDto map(BlogPost source);

  BlogPost map(BlogPostDto source);

  void copy(BlogPostDto source, @MappingTarget BlogPost target);

  void copy(BlogPost source, @MappingTarget BlogPostDto target);
}
