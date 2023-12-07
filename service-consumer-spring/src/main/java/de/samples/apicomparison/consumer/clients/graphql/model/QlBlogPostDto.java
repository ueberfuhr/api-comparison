package de.samples.apicomparison.consumer.clients.graphql.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public @Data class QlBlogPostDto {

  private UUID id;
  private String title;
  private String content;
  private LocalDateTime timestamp;
  private QlAuthorDto author;
  private Collection<QlHashTagDto> tags;

}
