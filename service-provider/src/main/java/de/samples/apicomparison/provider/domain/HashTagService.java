package de.samples.apicomparison.provider.domain;

import de.samples.apicomparison.provider.domain.model.HashTag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.stream.Stream;

@Validated
public interface HashTagService {

  long count();

  void save(@Valid HashTag hashTag);

  void deleteByName(@NotEmpty String name) throws NotFoundException;

  Optional<HashTag> findByName(@NotEmpty String name);

  default HashTag findByNameOrThrow(@NotEmpty String name) throws NotFoundException {
    return this.findByName(name)
      .orElseThrow(NotFoundException::new);
  }

  Stream<HashTag> findAllByNames(@NotNull @Size(min = 1) String... name);

  Stream<HashTag> findAll();

}
