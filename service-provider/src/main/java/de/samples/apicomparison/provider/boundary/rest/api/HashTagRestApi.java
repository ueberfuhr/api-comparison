package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.config.OpenApiConstants;
import de.samples.apicomparison.provider.boundary.rest.api.config.UriMappingResolver;
import de.samples.apicomparison.provider.boundary.rest.api.model.HashTagDto;
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

import java.util.stream.Stream;

@V1Api
@RequestMapping("/hashtags")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_HASHTAG_NAME)
public interface HashTagRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    operationId = "findAllHashTags",
    summary = "Read all available hash tag details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The descriptions were found and returned.",
    content = @Content(
      array = @ArraySchema(
        schema = @Schema(
          implementation = HashTagDto.class
        )
      )
    ))
  Stream<HashTagDto> findAll();

  @GetMapping(
    value = "/{name}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    operationId = "findHashTagByName",
    summary = "Read hash tag details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The description was found and returned."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The metadata could not be found."
  )
  HashTagDto findByName(
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name
  );

  @PutMapping(
    value = "/{name}",
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    operationId = "assignHashTagMetadata",
    summary = "Assign some metadata to a hash tag name."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The metadata was assigned for the first time.",
    headers = @Header(
      name = OpenApiConstants.LOCATION_HEADER_NAME,
      ref = OpenApiConstants.LOCATION_HEADER_COMPONENT_NAME
    )
  )
  @ApiResponse(
    responseCode = "204",
    description = "The metadata already existed and was successfully replaced."
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid."
  )
  default ResponseEntity<Void> saveWithResponse(
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name,
    @Valid
    @RequestBody
    HashTagDto tag,
    @Schema(hidden = true)
    UriMappingResolver uriMappingResolver
  ) {
    tag.setName(name);
    return (
      switch (this.save(tag)) {
        case CREATED -> ResponseEntity.created(
          uriMappingResolver.resolve(
            this.getClass(),
            c -> c.findByName(name)
          )
        );
        case REPLACED -> ResponseEntity.noContent();
      }
    ).build();
  }

  enum SaveResult {
    CREATED, REPLACED
  }

  SaveResult save(HashTagDto tag);

  @DeleteMapping(
    value = "/{name}"
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    operationId = "deleteHashTagMetadata",
    summary = "Deletes the metadata of a hash tag name."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The metadata was successfully deleted."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The metadata did not exist before."
  )
  void delete(
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name
  );


}
