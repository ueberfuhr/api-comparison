package de.samples.apicomparison.consumer.clients.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Data
public class BlogPostDto {

  // reverse logic: needs to be deserialized, but must not be serialized
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private UUID id;
  @Size(min = 3)
  @NotNull
  private String title;
  @Size(min = 10)
  @NotNull
  private String content;
  // reverse logic: needs to be deserialized, but must not be serialized
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private LocalDateTime timestamp;

}
