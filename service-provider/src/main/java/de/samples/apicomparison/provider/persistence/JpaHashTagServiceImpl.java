package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.domain.HashTagService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import de.samples.apicomparison.provider.domain.model.HashTag;
import de.samples.apicomparison.provider.persistence.mappers.HashTagEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
  @Transactional
  public Optional<HashTag> findByName(String name) {
    return this.repo
      .findById(name)
      .map(this.mapper::map);
  }

  @Transactional
  @Override
  public Stream<HashTag> findAllByNamesWithDefaults(Collection<String> names) {
    return HashTagService.super.findAllByNamesWithDefaults(names);
  }

  @Override
  @Transactional
  public Stream<HashTag> findAllByNames(Collection<String> names) {
    return this.repo
      .streamAllByNameIsIn(names)
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }

  @Override
  @Transactional
  public Stream<HashTag> findAll() {
    return this.repo
      .streamAll()
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }
}
