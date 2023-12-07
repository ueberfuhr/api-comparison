package de.samples.apicomparison.consumer.clients.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String name;

  @NotEmpty
  private String description;

}
