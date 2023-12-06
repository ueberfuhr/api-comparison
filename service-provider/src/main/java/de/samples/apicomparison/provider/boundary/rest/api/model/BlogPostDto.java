package de.samples.apicomparison.provider.boundary.rest.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(
  name = "BlogPost",
  description = "A blog post contains a title and a content."
)
public @Data class BlogPostDto {

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Schema(description = "The id of the blog post.")
  private UUID id;
  @Size(min = 3)
  @NotNull
  @Schema(description = "The title of the blog post.")
  private String title;
  @Size(min = 10)
  @NotNull
  @Schema(description = "The content of the blog post.")
  private String content;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Schema(description = "The timestamp the blog post was saved.")
  private LocalDateTime timestamp;

}
