package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.domain.AuthorService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import de.samples.apicomparison.provider.domain.model.Author;
import de.samples.apicomparison.provider.persistence.mappers.AuthorEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class JpaAuthorServiceImpl implements AuthorService {

  private final AuthorEntityMapper mapper;
  private final AuthorRepository repo;

  @Override
  public long count() {
    return this.repo.count();
  }

  protected void save(Author author) {
    final var entity = this.mapper.map(author);
    final var savedEntity = this.repo.save(entity);
    this.mapper.copy(savedEntity, author);
  }

  @Override
  public void create(Author author) {
    this.save(author);
  }

  @Override
  public void update(Author author) throws NotFoundException {
    if (!repo.existsById(author.getId())) {
      throw new NotFoundException();
    }
    this.save(author);
  }

  @Override
  public void deleteById(UUID id) throws NotFoundException {
    if (!this.repo.existsById(id)) {
      throw new NotFoundException();
    }
    this.repo.deleteById(id);
  }

  @Override
  public Optional<Author> findById(UUID id) {
    return repo.findById(id)
      .map(this.mapper::map);
  }

  @Override
  @Transactional
  public Stream<Author> findAll() {
    return this.repo
      .streamAll()
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }

  @Override
  @Transactional
  public Stream<Author> findAllByName(String name) {
    return this.repo
      .streamAllByName(name)
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }

}
