package de.samples.apicomparison.provider.boundary.soap.mappers;

import de.samples.apicomparison.provider.domain.model.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
  componentModel = "spring",
  uses = {
    HashTagSoapStubMapper.class,
    AuthorSoapStubMapper.class
  }
)
public interface BlogPostSoapStubMapper {

  de.samples.apicomparison.stubs.soap.model.BlogPost map(BlogPost source);

  @Mapping(target = "author", ignore = true)
  BlogPost map(de.samples.apicomparison.stubs.soap.messages.BlogPostInput source);

}
