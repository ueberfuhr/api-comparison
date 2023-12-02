package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.model.HashTagDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RequestMapping("/api/v1/hashtags")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_HASHTAG_NAME)
public interface HashTagRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read all available hash tag details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The descriptions were found and returned."
  )
  Stream<HashTagDto> findAll();

  @PutMapping(
    value = "/{name}",
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    summary = "Assign some metadata to a hash tag name."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The metadata was assigned for the first time."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The metadata already existed and was successfully replaced."
  )
  void save(
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name,
    @Valid
    @RequestBody
    HashTagDto tag
  );

  @DeleteMapping(
    value = "/{name}"
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
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
