package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.model.AuthorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@V1Api
@RequestMapping("/authors")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_AUTHOR_NAME)
public interface AuthorRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read all available author details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The authors were found and returned."
  )
  Stream<AuthorDto> findAll(
    @Parameter(
      name = "name",
      description = "If specified, only authors with the given name are returned"
    )
    @RequestParam(
      name = "name",
      required = false
    )
    String name
  );

  @GetMapping(
    value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read author details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The author was found and returned."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The author could not be found."
  )
  AuthorDto findById(
    @Parameter(ref = OpenApiConstants.AUTHOR_ID_PARAMETER)
    @PathVariable("id")
    UUID id
  );

  @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Create the author's data."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The author was successfully created.",
    headers = @Header(name = "Location", description = "URL to the newly created author")
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid."
  )
  default ResponseEntity<AuthorDto> create(
    @Valid
    @RequestBody
    AuthorDto author
  ) {
    author.setId(null); // just to be sure
    this.save(author);
    return ResponseEntity
      .created(
        linkTo(
          methodOn(AuthorRestApi.class).findById(author.getId())
        ).toUri()
      )
      .body(author);
  }

  @PutMapping(
    value = "/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    summary = "Replace the author's data."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The author was successfully replaced."
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The author could not be found."
  )
  default void replace(
    @Parameter(ref = OpenApiConstants.AUTHOR_ID_PARAMETER)
    @PathVariable("id")
    UUID id,
    @Valid
    @RequestBody
    AuthorDto author
  ) {
    author.setId(id);
    this.save(author);
  }

  void save(AuthorDto author);

}
