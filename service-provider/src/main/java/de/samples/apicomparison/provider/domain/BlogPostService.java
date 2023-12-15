package de.samples.apicomparison.provider.domain;

import de.samples.apicomparison.provider.domain.config.ValidationGroups;
import de.samples.apicomparison.provider.domain.events.BlogPostCreatedEvent;
import de.samples.apicomparison.provider.domain.events.BlogPostDeletedEvent;
import de.samples.apicomparison.provider.domain.events.BlogPostUpdatedEvent;
import de.samples.apicomparison.provider.domain.interceptors.PublishEvent;
import de.samples.apicomparison.provider.domain.model.BlogPost;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Validated
public interface BlogPostService {

  long count();

  @PublishEvent(BlogPostCreatedEvent.class)
  void create(@Validated(ValidationGroups.OnCreate.class) BlogPost post);

  @PublishEvent(BlogPostUpdatedEvent.class)
  void update(@Validated(ValidationGroups.OnUpdate.class) BlogPost post) throws NotFoundException;

  @PublishEvent(BlogPostDeletedEvent.class)
  void deleteById(@NotNull UUID id) throws NotFoundException;

  Optional<BlogPost> findById(@NotNull UUID id);

  default BlogPost findByIdOrThrow(@NotNull UUID id) throws NotFoundException {
    return this.findById(id)
      .orElseThrow(NotFoundException::new);
  }

  Stream<BlogPost> findAll();

  Stream<BlogPost> findAllByAuthor(@NotNull String name);

  Stream<BlogPost> findAllByHashTag(@NotNull String tag);

  Stream<BlogPost> findAllByTimestamp(@NotNull LocalDateTime startTime, LocalDateTime endTime);

}
