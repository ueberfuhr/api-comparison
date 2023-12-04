package de.samples.apicomparison.provider.boundary.rest.api;

import de.samples.apicomparison.provider.boundary.rest.api.config.OpenApiConstants;
import de.samples.apicomparison.provider.boundary.rest.api.model.BlogPostDto;
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
@RequestMapping("/blogposts")
@ResponseBody
@Tag(name = OpenApiConstants.TAG_BLOGPOST_NAME)
public interface BlogPostRestApi {

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read all available blog post details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The blog posts were found and returned."
  )
  Stream<BlogPostDto> findAll(
    @Parameter(
      name = "author",
      description = "If specified, only blog posts with the given author name are returned"
    )
    @RequestParam(
      name = "author",
      required = false
    )
    String authorName
  );

  @GetMapping(
    value = "/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Read blog post details."
  )
  @ApiResponse(
    responseCode = "200",
    description = "The blog post was found and returned."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found."
  )
  BlogPostDto findById(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID id
  );

  @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Create the blog post."
  )
  @ApiResponse(
    responseCode = "201",
    description = "The blog post was successfully created.",
    headers = @Header(name = "Location", description = "URL to the newly created blog post")
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid."
  )
  default ResponseEntity<BlogPostDto> create(
    @Valid
    @RequestBody
    BlogPostDto post
  ) {
    post.setId(null); // just to be sure
    this.save(post);
    return ResponseEntity
      .created(
        linkTo(
          methodOn(BlogPostRestApi.class).findById(post.getId())
        ).toUri()
      )
      .body(post);
  }

  @PutMapping(
    value = "/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    summary = "Replace the blog post."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The blog post was successfully replaced."
  )
  @ApiResponse(
    responseCode = "400",
    description = "The sent data is not valid."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post could not be found."
  )
  default BlogPostDto replace(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID id,
    @Valid
    @RequestBody
    BlogPostDto post
  ) {
    post.setId(id);
    this.save(post);
    return post;
  }

  void save(BlogPostDto post);

  @DeleteMapping(
    value = "/{id}"
  )
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(
    summary = "Deletes the metadata of a hash tag name."
  )
  @ApiResponse(
    responseCode = "204",
    description = "The blog post was successfully deleted."
  )
  @ApiResponse(
    responseCode = "404",
    description = "The blog post did not exist before."
  )
  void delete(
    @Parameter(ref = OpenApiConstants.BLOGPOST_ID_PARAMETER)
    @PathVariable("id")
    UUID id
  );

  // set tag (tag: author/hashtag)
  // remove tag
}
