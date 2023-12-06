package de.samples.apicomparison.provider.boundary.graphql.mappers;

import de.samples.apicomparison.provider.boundary.graphql.model.QlHashTagDto;
import de.samples.apicomparison.provider.domain.model.HashTag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashTagMapper {

  QlHashTagDto map(HashTag source);

}
