package de.samples.apicomparison.consumer.clients.graphql.model;

import lombok.Data;

import java.util.UUID;

public @Data class QlAuthorDto {

  private UUID id;
  private String name;
  private String description;

}
