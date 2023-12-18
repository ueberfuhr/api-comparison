package de.samples.apicomparison.provider.boundary.grpc.mappers;

import de.samples.apicomparison.provider.domain.model.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
  componentModel = "spring",
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
  uses = {
    AuthorMapper.class,
    UuidMapper.class,
    TimestampMapper.class
  }
)
public interface BlogPostMapper {

  de.samples.apicomparison.provider.boundary.grpc.stub.BlogPost map(BlogPost source);

}
