package de.samples.apicomparison.provider.boundary.rest.impl;

import de.samples.apicomparison.provider.boundary.rest.api.AuthorRestApi;
import de.samples.apicomparison.provider.boundary.rest.api.model.AuthorDto;
import de.samples.apicomparison.provider.boundary.rest.impl.mappers.AuthorDtoMapper;
import de.samples.apicomparison.provider.domain.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.UUID;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class AuthorRestController implements AuthorRestApi {

  private final AuthorService service;
  private final AuthorDtoMapper mapper;

  @Override
  public Stream<AuthorDto> findAll(String name) {
    return (null != name && !name.isEmpty()
      ? this.service.findAllByName(name)
      : this.service.findAll()
    )
      .map(this.mapper::map);
  }

  @Override
  public AuthorDto findById(UUID id) {
    return null;
  }

  @Override
  public void save(AuthorDto author) {

  }
}
