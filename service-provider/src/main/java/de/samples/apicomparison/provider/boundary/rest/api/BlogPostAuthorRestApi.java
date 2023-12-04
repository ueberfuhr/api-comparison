package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.config.OpenApiConstants;
import de.samples.apicomparison.provider.boundary.rest.api.config.UriMappingResolver;
import de.samples.apicomparison.provider.boundary.rest.api.model.AuthorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@V1Api
@RequestMapping("/blogposts/{id}/author")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_BLOGPOST_NAME)
@Tag(name = OpenApiConstants.TAG_AUTHOR_NAME)
public interface BlogPostAuthorRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read the author of the blog post."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The author of the blog post could be found."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found or does not have an assigned author."
  )
  AuthorDto getAuthor(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId
  );

  @PutMapping(
    consumes = MediaType.TEXT_PLAIN_VALUE
  )
  @Operation(
    summary = "Assigns the author to the blog post."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The author was newly assigned to the blog post.",
    headers = @Header(name = "Location", description = "URL to the newly assigned author.")
  )
  @ApiResponse(
    responseCode = "204",
    description = "The author of the blog post was successfully replaced."
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid. Maybe, the author does not exist."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found."
  )
  default ResponseEntity<Void> assignWithResponse(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId,
    @Valid
    @RequestBody
    UUID authorId,
    @Schema(hidden = true)
    UriMappingResolver uriMappingResolver
  ) {
    return (
      switch (this.assign(blogPostId, authorId)) {
        case CREATED -> ResponseEntity.created(
          uriMappingResolver.resolve(
            this.getClass(),
            c -> c.getAuthor(blogPostId)
          )
        );
        case REPLACED -> ResponseEntity.noContent();
      }
    ).build();
  }

  enum AssignResult {
    CREATED, REPLACED
  }

  AssignResult assign(UUID blogPostId, UUID authorId);

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    summary = "Deletes the author's assignment to the blog post."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The author's assignment to was successfully deleted."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post does not exist or did not have any assigned author before."
  )
  void delete(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID blogPostId
  );


}
