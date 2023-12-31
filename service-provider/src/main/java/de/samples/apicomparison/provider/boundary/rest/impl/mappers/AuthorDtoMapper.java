package de.samples.apicomparison.provider.boundary.rest.impl.mappers;

import de.samples.apicomparison.provider.boundary.rest.api.model.AuthorDto;
import de.samples.apicomparison.provider.domain.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorDtoMapper {

  AuthorDto map(Author source);

  Author map(AuthorDto source);

  void copy(Author source, @MappingTarget AuthorDto target);
}
