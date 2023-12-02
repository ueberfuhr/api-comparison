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
  public void save(String name, HashTagDto tag) {
    tag.setName(name);
    this.service
      .save(this.mapper.map(tag));
  }

  @Override
  public void delete(String name) {
    this.service
      .deleteByName(name);
  }
}
