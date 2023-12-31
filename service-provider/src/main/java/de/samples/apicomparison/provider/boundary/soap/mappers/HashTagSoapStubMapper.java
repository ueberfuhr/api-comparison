package de.samples.apicomparison.provider.boundary.soap.mappers;

import de.samples.apicomparison.provider.domain.model.HashTag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HashTagSoapStubMapper {

  de.samples.apicomparison.stubs.soap.model.HashTag map(HashTag source);

}
