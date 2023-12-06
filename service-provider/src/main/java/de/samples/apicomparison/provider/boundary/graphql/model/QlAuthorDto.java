package de.samples.apicomparison.provider.boundary.graphql.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

public @Data class QlAuthorDto {

  private UUID id;
  @NotEmpty
  private String name;
  private String description;

}
