package de.samples.apicomparison.provider.boundary.graphql.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public @Data class QlBlogPostDto {

  private UUID id;
  @Size(min = 3)
  @NotNull
  private String title;
  @Size(min = 10)
  @NotNull
  private String content;
  private LocalDateTime timestamp;

  private UUID authorId;
  private Collection<String> tags;

}
