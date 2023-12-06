package de.samples.apicomparison.provider.domain;

import de.samples.apicomparison.provider.domain.model.HashTag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Validated
@SuppressWarnings("unused")
public interface HashTagService {

  long count();

  void save(@Valid HashTag hashTag);

  void deleteByName(@NotEmpty String name) throws NotFoundException;

  Optional<HashTag> findByName(@NotEmpty String name);

  default HashTag findByNameOrThrow(@NotEmpty String name) throws NotFoundException {
    return this.findByName(name)
      .orElseThrow(NotFoundException::new);
  }

  default Stream<HashTag> findAllByNamesWithDefaults(@NotNull @Size(min = 1) Collection<String> names) {
    final var existingTagsByName = this.findAllByNames(names)
      .collect(Collectors.toMap(HashTag::getName, Function.identity()));
    return names.stream()
      .map(
        name -> existingTagsByName.getOrDefault(
          name,
          HashTag.builder().name(name).build()
        )
      );
  }

  Stream<HashTag> findAllByNames(@NotNull @Size(min = 1) Collection<String> names);

  Stream<HashTag> findAll();

}
