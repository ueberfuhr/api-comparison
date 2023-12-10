package de.samples.apicomparison.consumer.clients.soap;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class HttpSoapClient {

  private final WebClient webClient;

  public <T> Mono<T> call(Object request, Class<T> responseType) {
    return webClient.post()
      .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_XML_VALUE)
      .bodyValue(request)
      .retrieve()
      .bodyToMono(responseType);
  }

}
