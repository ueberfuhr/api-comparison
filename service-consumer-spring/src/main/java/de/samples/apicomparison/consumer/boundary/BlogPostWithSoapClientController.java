package de.samples.apicomparison.consumer.boundary;

import de.samples.apicomparison.consumer.clients.soap.BlogPostSoapClient;
import de.samples.apicomparison.stubs.soap.messages.BlogPostInput;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/blog-soap")
@RequiredArgsConstructor
public class BlogPostWithSoapClientController {

  private final BlogPostSoapClient blogPostApi;

  @GetMapping
  public String showBlogPosts(final Model model) {
    //noinspection ReactiveStreamsUnusedPublisher
    model.addAttribute(
      "blogposts",
      new ReactiveDataDriverContextVariable(
        this.blogPostApi
          .findAll(),
        1
      )
    );
    return "blog-soap";
  }

  // this does not work here ([SPR-16190]):
  //    @RequestParam
  //    String title,
  //    @RequestParam
  //    String content
  @PostMapping
  public Mono<String> create(
    ServerWebExchange exchange
  ) {
    return exchange.getFormData()
      .map(
        data -> {
          BlogPostInput dto = new BlogPostInput();
          dto.setTitle(data.getFirst("title"));
          dto.setContent(data.getFirst("content")); // Validation?!
          return dto;
        }
      )
      .flatMap(this.blogPostApi::create)
      .then(Mono.just("redirect:/blog-soap"));
  }

  protected UUID getId(MultiValueMap<String, String> data) {
    try {
      return Optional.ofNullable(data.getFirst("id"))
        .map(UUID::fromString)
        .orElseThrow(ValidationException::new);
    } catch (IllegalArgumentException e) {
      throw new ValidationException(e);
    }
  }

  @PostMapping("/delete")
  public Mono<String> delete(
    ServerWebExchange exchange
  ) {
    return exchange.getFormData()
      .map(this::getId)
      .flatMap(this.blogPostApi::delete)
      .then(Mono.just("redirect:/blog-soap"));
  }

}
