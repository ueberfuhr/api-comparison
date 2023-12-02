package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.domain.HashTagService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import de.samples.apicomparison.provider.domain.model.HashTag;
import de.samples.apicomparison.provider.persistence.mappers.HashTagEntityMapper;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class JpaHashTagServiceImpl implements HashTagService {

  private final HashTagEntityMapper mapper;
  private final HashTagRepository repo;

  @Override
  public long count() {
    return this.repo.count();
  }

  @Override
  public void save(HashTag hashTag) {
    final var entity = this.mapper.map(hashTag);
    final var savedEntity = this.repo.save(entity);
    this.mapper.copy(savedEntity, hashTag);
  }

  @Override
  public void deleteByName(String name) throws NotFoundException {
    if (!this.repo.existsById(name)) {
      throw new NotFoundException();
    }
    this.repo.deleteById(name);
  }

  @Override
  public Optional<HashTag> findByName(String name) {
    return this.repo.findById(name)
      .map(this.mapper::map);
  }

  @Override
  public Stream<HashTag> findAllByNames(@NotNull @Size(min = 1) String... names) {
    return this.repo
      .streamAllByNameIsIn(Arrays.asList(names))
      .map(this.mapper::map);
  }

  @Override
  public Stream<HashTag> findAll() {
    return this.repo
      .streamAll()
      .map(this.mapper::map);
  }
}
