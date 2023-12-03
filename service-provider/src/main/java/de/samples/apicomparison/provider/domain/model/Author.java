package de.samples.apicomparison.provider.domain.model;

import de.samples.apicomparison.provider.domain.config.ValidationGroups;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class Author {

  @Null(groups = ValidationGroups.OnCreate.class)
  @NotNull(groups = ValidationGroups.OnUpdate.class)
  private UUID id;
  @NotEmpty
  private String name;
  private String description;

}
