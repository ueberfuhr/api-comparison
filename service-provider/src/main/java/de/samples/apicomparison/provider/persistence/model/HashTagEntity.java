package de.samples.apicomparison.provider.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "HashTag")
@Table(name = "HASH_TAGS")
@Getter
@Setter
public class HashTagEntity {

  @Id
  private String name;
  private String description;

}
