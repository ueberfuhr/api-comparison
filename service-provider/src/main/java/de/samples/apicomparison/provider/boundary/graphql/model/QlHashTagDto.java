package de.samples.apicomparison.provider.boundary.graphql.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

public @Data class QlHashTagDto {

  String name;

  @NotEmpty
  String description;

}
