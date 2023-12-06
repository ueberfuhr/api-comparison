package de.samples.apicomparison.provider.boundary.graphql.mappers;

import de.samples.apicomparison.provider.boundary.graphql.model.QlAuthorDto;
import de.samples.apicomparison.provider.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

  QlAuthorDto map(Author source);

}
