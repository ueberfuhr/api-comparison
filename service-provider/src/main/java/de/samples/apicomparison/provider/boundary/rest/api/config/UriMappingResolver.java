package de.samples.apicomparison.provider.boundary.rest.api.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Use this resolver to get URIs to handler methods that
 * are aware of PathMatchConfigurer configurations in WebMvc.
 *
 * @see <a href="https://github.com/spring-projects/spring-hateoas/issues/1221">
 *   Spring HATEOAS Issue 1221
 *   </a>
 */
@RequiredArgsConstructor
public class UriMappingResolver {

  private final Supplier<Map<String, Predicate<Class<?>>>> pathPrefixes;

  protected Optional<String> getBasePath(Class<?> controllerClass) {
    return this.pathPrefixes
      .get()
      .entrySet()
      .stream()
      .filter(e -> e.getValue().test(controllerClass))
      .findFirst()
      .map(Map.Entry::getKey);
  }

  @SneakyThrows
  private static URI derive(URI original, String basePath) {
    return new URI(
      original.getScheme(),
      original.getUserInfo(),
      original.getHost(),
      original.getPort(),
      basePath + original.getPath(),
      original.getQuery(),
      original.getFragment()
    );
  }

  public <ControllerClass> URI resolve(Class<ControllerClass> c, Function<ControllerClass, ?> methodOn) {
    final var uri = WebMvcLinkBuilder.linkTo(
      methodOn.apply(WebMvcLinkBuilder.methodOn(c))
    ).toUri();
    return this.getBasePath(c)
      .map(basePath -> derive(uri, basePath))
      .orElse(uri);
  }

}
