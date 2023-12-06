package de.samples.apicomparison.consumer.clients.rest;

import de.samples.apicomparison.consumer.clients.rest.config.HttpClient;
import de.samples.apicomparison.consumer.clients.rest.model.BlogPostDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Validated
@HttpClient
@HttpExchange("/api/v1/blogposts")
public interface BlogPostRestApiClient {

  default Flux<BlogPostDto> getAll() {
    return this.getAll(null);
  }
  @GetExchange
  Flux<BlogPostDto> getAll(@RequestParam(required = false) String author);

  @PostExchange
  Mono<BlogPostDto> create(@Valid @RequestBody BlogPostDto post);

  @DeleteExchange("/{id}")
  Mono<Void> delete(@PathVariable UUID id);

}
