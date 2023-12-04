package de.samples.apicomparison.provider.domain.model;

import de.samples.apicomparison.provider.domain.config.ValidationGroups;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Builder
@Getter
@Setter
public class BlogPost {

  @Null(groups = ValidationGroups.OnCreate.class)
  @NotNull(groups = ValidationGroups.OnUpdate.class)
  private UUID id;
  @Size(min = 3)
  @NotNull
  private String title;
  @Size(min = 10)
  @NotNull
  private String content;
  private LocalDateTime timestamp;
  private Author author;
  private Collection<String> tags;

}
