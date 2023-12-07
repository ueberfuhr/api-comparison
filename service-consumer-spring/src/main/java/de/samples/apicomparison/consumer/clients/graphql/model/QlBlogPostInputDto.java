package de.samples.apicomparison.consumer.clients.graphql.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

public @Data class QlBlogPostInputDto {

  @NotEmpty
  @Size(min = 3)
  private String title;
  @Size(min = 10)
  private String content;

}
