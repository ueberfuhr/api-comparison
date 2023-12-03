package de.samples.apicomparison.provider.boundary.rest.impl;

import de.samples.apicomparison.provider.boundary.rest.api.HashTagRestApi;
import de.samples.apicomparison.provider.boundary.rest.api.model.HashTagDto;
import de.samples.apicomparison.provider.boundary.rest.impl.mappers.HashTagDtoMapper;
import de.samples.apicomparison.provider.domain.HashTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class HashTagRestController implements HashTagRestApi {

  private final HashTagService service;
  private final HashTagDtoMapper mapper;

  @Override
  public Stream<HashTagDto> findAll() {
    return this.service
      .findAll()
      .map(mapper::map);
  }

  @Override
  public HashTagDto findByName(String name) {
    return this.mapper
      .map(
        this.service
          .findByNameOrThrow(name)
      );
  }

  @Override
  public SaveResult save(HashTagDto tag) {
    final var result = this.service
      .findByName(tag.getName())
      .isPresent() ? SaveResult.REPLACED : SaveResult.CREATED;
    this.service
      .save(this.mapper.map(tag));
    return result;
  }

  @Override
  public void delete(String name) {
    this.service
      .deleteByName(name);
  }
}
