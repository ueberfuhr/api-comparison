package de.samples.apicomparison.provider.boundary.grpc.mappers;

import de.samples.apicomparison.provider.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(
  componentModel = "spring",
  uses = UuidMapper.class
)
public interface AuthorMapper {

  de.samples.apicomparison.provider.boundary.grpc.stub.Author map(Author source);

}
