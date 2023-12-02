package de.samples.apicomparison.provider.persistence.mappers;

import de.samples.apicomparison.provider.domain.model.Author;
import de.samples.apicomparison.provider.persistence.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorEntityMapper {

  AuthorEntity map(Author source);

  Author map(AuthorEntity source);

  void copy(AuthorEntity source, @MappingTarget Author target);
}
