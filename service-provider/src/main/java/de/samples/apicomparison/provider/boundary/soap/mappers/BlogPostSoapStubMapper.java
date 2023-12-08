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

  de.samples.apicomparison.provider.boundary.soap.stubs.BlogPost map(BlogPost source);

  BlogPost map(de.samples.apicomparison.provider.boundary.soap.stubs.BlogPost source);

}
