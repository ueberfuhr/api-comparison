package de.samples.apicomparison.provider.boundary.grpc;

import io.grpc.stub.StreamObserver;
import lombok.experimental.UtilityClass;

import java.util.function.Function;

@UtilityClass
public class StreamObserverUtility {

  <Target, Source> StreamObserver<Source> proxyStream(StreamObserver<Target> target, Function<Source, Target> handler) {
    return new StreamObserver<>() {
      @Override
      public void onNext(Source value) {
        final var targetValue = handler.apply(value);
        target.onNext(targetValue);
      }

      @Override
      public void onError(Throwable t) {
        target.onError(t);
      }

      @Override
      public void onCompleted() {
        target.onCompleted();
      }
    };
  }

}
