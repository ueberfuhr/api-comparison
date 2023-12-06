package de.samples.apicomparison.provider.boundary.rest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

@Schema(
  name = "Author",
  description = "Information about a blog post's author"
)
public @Data class AuthorDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Schema(description = "The id of the author.")
  private UUID id;
  @NotEmpty
  @Schema(description = "The name of the author.")
  private String name;
  @Schema(description = "A description for the author.")
  private String description;

}
