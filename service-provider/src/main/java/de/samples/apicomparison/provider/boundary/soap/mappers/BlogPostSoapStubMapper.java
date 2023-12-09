package de.samples.apicomparison.provider.boundary.soap.mappers;

import de.samples.apicomparison.provider.domain.model.BlogPost;
import org.mapstruct.InheritInverseConfiguration;
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

  de.samples.apicomparison.provider.boundary.soap.stub.model.BlogPost map(BlogPost source);

  @Mapping(target = "author", ignore = true)
  BlogPost map(de.samples.apicomparison.provider.boundary.soap.stub.messages.BlogPostInput source);

}
