package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.persistence.model.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity, UUID> {

  Stream<BlogPostEntity> streamAllByAuthorNameOrderByTimestampDesc(String author);

  Stream<BlogPostEntity> streamAllByTagsContainingIgnoreCase(String tag);

  Stream<BlogPostEntity> streamAllByTimestampBetweenOrderByTimestampDesc(
    LocalDateTime startTime, LocalDateTime endTime);

}
