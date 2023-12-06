package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.config.OpenApiConstants;
import de.samples.apicomparison.provider.boundary.rest.api.config.UriMappingResolver;
import de.samples.apicomparison.provider.boundary.rest.api.model.HashTagDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Stream;

@V1Api
@RequestMapping("/blogposts/{id}/hashtags")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_BLOGPOST_NAME)
@Tag(name = OpenApiConstants.TAG_HASHTAG_NAME)
public interface BlogPostHashTagsRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read the hash tags assigned to the blog post."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The hash tags could be found."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found."
  )
  Stream<HashTagDto> findAll(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId
  );

  @GetMapping(
    value = "/{name}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read a single hash tag assigned to the blog post."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The hash tag is assigned to the blog post."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found or does not have the hash tag assigned."
  )
  HashTagDto findByName(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId,
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name
  );

  @PutMapping(
    value = "/{name}"
  )
  @Operation(
    summary = "Assigns the hash tag to the blog post."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The hash tag was newly assigned to the blog post.",
    headers = @Header(name = "Location", description = "URL to the newly assigned hash tag.")
  )
  @ApiResponse(
    responseCode = "204",
    description = "The hash tag was already assigned."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found."
  )
  default ResponseEntity<Void> assignWithResponse(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId,
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name,
    @Schema(hidden = true)
    UriMappingResolver uriMappingResolver
  ) {
    return (
      switch (this.assign(blogPostId, name)) {
        case CREATED -> ResponseEntity.created(
          uriMappingResolver.resolve(
            this.getClass(),
            c -> c.findByName(blogPostId, name)
          )
        );
        case REPLACED -> ResponseEntity.noContent();
      }
    ).build();
  }

  enum AssignResult {
    CREATED, REPLACED
  }

  AssignResult assign(UUID blogPostId, String name);

  @DeleteMapping(
    value = "/{name}"
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    summary = "Deletes the hash tag assignment to the blog post."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The hash tag assignment to was successfully deleted."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post does not exist."
  )
  void delete(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId,
    @Parameter(ref = OpenApiConstants.HASHTAG_NAME_PARAMETER)
    @PathVariable("name")
    String name
  );

}
