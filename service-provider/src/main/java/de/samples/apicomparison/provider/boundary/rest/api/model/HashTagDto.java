package de.samples.apicomparison.provider.boundary.rest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(
  name = "HashTag",
  description = "A hash tag marks a blog post semantically."
)
public @Data class HashTagDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Schema(description = "The unique name of the hash tag.")
  String name;

  @NotEmpty
  @Schema(description = "A description for the hash tag.")
  String description;

}
