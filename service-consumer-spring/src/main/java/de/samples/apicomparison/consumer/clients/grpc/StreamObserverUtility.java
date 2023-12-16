package de.samples.apicomparison.consumer.clients.grpc;

import io.grpc.stub.StreamObserver;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Function;

@UtilityClass
public class StreamObserverUtility {

  public record StreamObserverFluxPair<S, T>(
    StreamObserver<S> streamObserver,
    Flux<T> flux
  ) {
  }

  public <T> StreamObserverFluxPair<T, T> createStreamObserverFluxPair() {
    return createStreamObserverFluxPair(Function.identity());
  }

  public <S, T> StreamObserverFluxPair<S, T> createStreamObserverFluxPair(final Function<S, T> transformer) {
    final var behaviorSubject = Sinks
      .many()
      .replay()
      .<T>all();
    final var flux = behaviorSubject.asFlux();
    final var streamObserver = new StreamObserver<S>() {

      @Override
      public void onNext(S value) {
        final var transformedValue = transformer.apply(value);
        behaviorSubject.tryEmitNext(transformedValue);
      }

      @Override
      public void onError(Throwable t) {
        behaviorSubject.tryEmitError(t);
      }

      @Override
      public void onCompleted() {
        behaviorSubject.tryEmitComplete();
      }
    };
    return new StreamObserverFluxPair<>(
      streamObserver,
      flux
    );
  }

}
