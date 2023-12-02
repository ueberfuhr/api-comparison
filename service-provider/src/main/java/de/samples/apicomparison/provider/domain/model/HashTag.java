package de.samples.apicomparison.provider.domain.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
public class HashTag {

  @NotEmpty
  private String name;
  @NotEmpty
  @EqualsAndHashCode.Exclude
  private String description;

}
