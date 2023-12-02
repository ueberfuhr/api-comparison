package de.samples.apicomparison.provider.domain;

import de.samples.apicomparison.provider.config.ValidationGroups;
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

    void create(@Validated(ValidationGroups.OnCreate.class) BlogPost post);

    void update(@Validated(ValidationGroups.OnUpdate.class) BlogPost post) throws NotFoundException;

    void deleteById(@NotNull UUID id) throws NotFoundException;

    Optional<BlogPost> findById(@NotNull UUID id);

    default BlogPost findByIdOrThrow(@NotNull UUID id) throws NotFoundException {
        return this.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    Stream<BlogPost> findAllByAuthor(@NotNull String name);

    Stream<BlogPost> findAllByHashTag(@NotNull String tag);

    Stream<BlogPost> findAllByTimestamp(@NotNull LocalDateTime startTime, LocalDateTime endTime);

}
