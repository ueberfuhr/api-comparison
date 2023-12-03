package de.samples.apicomparison.provider.persistence;

import de.samples.apicomparison.provider.persistence.model.HashTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Stream;

@Repository
public interface HashTagRepository extends JpaRepository<HashTagEntity, String> {

  @Query("select t from HashTag t")
  Stream<HashTagEntity> streamAll();

  Stream<HashTagEntity> streamAllByNameIsIn(Collection<String> names);

}
