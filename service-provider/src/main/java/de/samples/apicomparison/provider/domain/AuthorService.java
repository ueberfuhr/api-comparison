package de.samples.apicomparison.provider.domain;

import de.samples.apicomparison.provider.domain.config.ValidationGroups;
import de.samples.apicomparison.provider.domain.model.Author;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Validated
public interface AuthorService {

  long count();

  void create(@Validated(ValidationGroups.OnCreate.class) Author author);

  void update(@Validated(ValidationGroups.OnUpdate.class) Author author) throws NotFoundException;

  void deleteById(@NotNull UUID id) throws NotFoundException;

  Optional<Author> findById(@NotNull UUID id);

  Stream<Author> findAll();

  default Author findByIdOrThrow(@NotNull UUID id) throws NotFoundException {
    return this.findById(id)
      .orElseThrow(NotFoundException::new);
  }

  Stream<Author> findAllByName(@NotNull String name);

}
