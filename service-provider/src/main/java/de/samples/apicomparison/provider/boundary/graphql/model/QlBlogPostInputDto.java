package de.samples.apicomparison.provider.boundary.graphql.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

public @Data class QlBlogPostInputDto {

  @Size(min = 3)
  @NotNull
  private String title;
  @Size(min = 10)
  @NotNull
  private String content;

}
