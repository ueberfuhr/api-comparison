package de.samples.apicomparison.provider.boundary.rest.impl.mappers;

import de.samples.apicomparison.provider.boundary.rest.api.model.HashTagDto;
import de.samples.apicomparison.provider.domain.model.HashTag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashTagDtoMapper {

  HashTagDto map(HashTag source);

  HashTag map(HashTagDto source);

}
