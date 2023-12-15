package de.samples.apicomparison.provider.boundary.grpc.mappers;

import de.samples.apicomparison.provider.domain.model.BlogPost;
import org.mapstruct.Mapper;

@Mapper(
  componentModel = "spring",
  uses = {
    AuthorMapper.class,
    UuidMapper.class,
    TimestampMapper.class
  }
)
public interface BlogPostMapper {

  de.samples.apicomparison.provider.boundary.grpc.stub.BlogPost map(BlogPost source);

}
