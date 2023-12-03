package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.persistence.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {

  @Query("select a from Author a")
  Stream<AuthorEntity> streamAll();

  Stream<AuthorEntity> streamAllByName(String name);

}
