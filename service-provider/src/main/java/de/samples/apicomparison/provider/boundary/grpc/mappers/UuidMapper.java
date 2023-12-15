package de.samples.apicomparison.provider.boundary.grpc.mappers;

import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UuidMapper {

  default de.samples.apicomparison.provider.boundary.grpc.stub.UUID map(UUID source) {
    if (null == source) {
      return null;
    }
    return de.samples.apicomparison.provider.boundary.grpc.stub.UUID.newBuilder()
      .setValue(source.toString())
      .build();
  }

  default UUID map(de.samples.apicomparison.provider.boundary.grpc.stub.UUID source) {
    if (null == source) {
      return null;
    }
    return UUID.fromString(source.getValue());
  }

}
