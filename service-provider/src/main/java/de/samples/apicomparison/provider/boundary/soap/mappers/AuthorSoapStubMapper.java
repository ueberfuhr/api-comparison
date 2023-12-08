package de.samples.apicomparison.provider.boundary.soap.mappers;

import de.samples.apicomparison.provider.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorSoapStubMapper {

  de.samples.apicomparison.provider.boundary.soap.stubs.Author map(Author source);

}
