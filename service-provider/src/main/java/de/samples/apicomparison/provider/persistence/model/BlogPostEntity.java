package de.samples.apicomparison.provider.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "BlogPost")
@Table(name = "BLOG_POSTS")
@Getter
@Setter
public class BlogPostEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String title;
  private String content;
  private LocalDateTime timestamp;
  @ManyToOne
  private AuthorEntity author;
  @ElementCollection(fetch = FetchType.EAGER)
  private Collection<String> tags;

  @PrePersist
  public void updateTimestamp() {
    this.timestamp = LocalDateTime.now();
  }

}
