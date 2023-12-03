package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.domain.BlogPostService;
import de.samples.apicomparison.provider.domain.NotFoundException;
import de.samples.apicomparison.provider.domain.model.BlogPost;
import de.samples.apicomparison.provider.persistence.mappers.BlogPostEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class JpaBlogPostServiceImpl implements BlogPostService {

  private final BlogPostEntityMapper mapper;
  private final BlogPostRepository repo;

  @Override
  public long count() {
    return this.repo.count();
  }

  protected void save(BlogPost post) {
    final var entity = this.mapper.map(post);
    final var savedEntity = this.repo.save(entity);
    this.mapper.copy(savedEntity, post);
  }

  @Override
  public void create(BlogPost post) {
    this.save(post);
  }

  @Override
  public void update(BlogPost post) throws NotFoundException {
    if (!repo.existsById(post.getId())) {
      throw new NotFoundException();
    }
    this.save(post);
  }

  @Override
  public void deleteById(UUID id) throws NotFoundException {
    if (!this.repo.existsById(id)) {
      throw new NotFoundException();
    }
    this.repo.deleteById(id);
  }

  @Override
  public Optional<BlogPost> findById(UUID id) {
    return repo.findById(id)
      .map(this.mapper::map);
  }

  @Override
  @Transactional
  public Stream<BlogPost> findAllByAuthor(String name) {
    return this.repo
      .streamAllByAuthorNameOrderByTimestampDesc(name)
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }

  @Override
  @Transactional
  public Stream<BlogPost> findAllByHashTag(String tag) {
    return this.repo
      .streamAllByTagsContainingIgnoreCase(tag)
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }

  @Override
  @Transactional
  public Stream<BlogPost> findAllByTimestamp(LocalDateTime startTime, LocalDateTime endTime) {
    return this.repo
      .streamAllByTimestampBetweenOrderByTimestampDesc(startTime, endTime)
      // TODO we collect all elements to allow closing the transaction - could we do this with a transaction around the whole request?
      .toList()
      .stream()
      .map(this.mapper::map);
  }

}
