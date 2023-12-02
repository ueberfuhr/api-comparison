package de.samples.apicomparison.provider.persistence.mappers;

import de.samples.apicomparison.provider.domain.model.HashTag;
import de.samples.apicomparison.provider.persistence.model.HashTagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HashTagEntityMapper {

  HashTagEntity map(HashTag source);

  HashTag map(HashTagEntity source);

  void copy(HashTagEntity source, @MappingTarget HashTag target);

}
