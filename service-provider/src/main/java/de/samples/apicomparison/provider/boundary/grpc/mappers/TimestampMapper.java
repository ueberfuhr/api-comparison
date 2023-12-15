package de.samples.apicomparison.provider.boundary.grpc.mappers;

import de.samples.apicomparison.provider.boundary.grpc.stub.Timestamp;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface TimestampMapper {

  default Timestamp map(LocalDateTime source) {
    if (null == source) {
      return null;
    }
    final var instant = source.toInstant(ZoneOffset.UTC);
    return Timestamp.newBuilder()
      .setSeconds(instant.getEpochSecond())
      .setNanos(instant.getNano())
      .build();
  }

  default LocalDateTime map(Timestamp source) {
    if (null == source) {
      return null;
    }
    return LocalDateTime.ofInstant(
      Instant.ofEpochSecond(source.getSeconds(), source.getNanos()),
      ZoneId.of("UTC")
    );
  }

}
