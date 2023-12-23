package de.samples.apicomparison.provider.boundary.grpc.mappers;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UuidMapper {

  default de.samples.apicomparison.stubs.grpc.UUID map(UUID source) {
    if (null == source) {
      return null;
    }
    return de.samples.apicomparison.stubs.grpc.UUID.newBuilder()
      .setValue(source.toString())
      .build();
  }

  default UUID map(de.samples.apicomparison.stubs.grpc.UUID source) {
    if (null == source || source.getValue().isEmpty()) {
      return null;
    }
    return UUID.fromString(source.getValue());
  }

}
