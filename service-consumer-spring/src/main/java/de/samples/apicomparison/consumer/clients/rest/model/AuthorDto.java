package de.samples.apicomparison.consumer.clients.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthorDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;
  @NotEmpty
  private String name;
  private String description;

}
