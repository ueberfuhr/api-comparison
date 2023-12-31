package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.config.OpenApiConstants;
import de.samples.apicomparison.provider.boundary.rest.api.config.UriMappingResolver;
import de.samples.apicomparison.provider.boundary.rest.api.model.AuthorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Stream;

@V1Api
@RequestMapping("/authors")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_AUTHOR_NAME)
public interface AuthorRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    operationId = "findAuthors",
    summary = "Read all available author details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The authors were found and returned.",
    content = @Content(
      array = @ArraySchema(
        schema = @Schema(
          implementation = AuthorDto.class
        )
      )
    ))
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
    operationId = "findAuthorById",
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
    operationId = "createAuthor",
    summary = "Create the author's data."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The author was successfully created.",
    headers = @Header(
      name = OpenApiConstants.LOCATION_HEADER_NAME,
      ref = OpenApiConstants.LOCATION_HEADER_COMPONENT_NAME
    )
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid."
  )
  default ResponseEntity<AuthorDto> create(
    @Valid
    @RequestBody
    AuthorDto author,
    @Schema(hidden = true)
    UriMappingResolver uriMappingResolver
  ) {
    author.setId(null); // just to be sure
    this.save(author);
    return ResponseEntity
      .created(
        uriMappingResolver.resolve(
          this.getClass(),
          c -> c.findById(author.getId())
        )
      )
      .body(author);
  }

  @PutMapping(
    value = "/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    operationId = "replaceAuthor",
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
