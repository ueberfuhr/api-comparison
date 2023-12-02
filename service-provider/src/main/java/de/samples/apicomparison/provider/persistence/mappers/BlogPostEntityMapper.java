package de.samples.apicomparison.provider.persistence.mappers;

import de.samples.apicomparison.provider.domain.model.BlogPost;
import de.samples.apicomparison.provider.persistence.model.BlogPostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = AuthorEntityMapper.class)
public interface BlogPostEntityMapper {

  BlogPostEntity map(BlogPost source);

  BlogPost map(BlogPostEntity source);

  void copy(BlogPostEntity source, @MappingTarget BlogPost target);

}
