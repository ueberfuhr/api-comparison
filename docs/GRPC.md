# Google Remote Procedure Call (gRPC)

## Basics

gRPC is a modern open source high performance Remote Procedure Call (RPC) framework that can run 
in any environment. It can efficiently connect services in and across data centers with pluggable 
support for load balancing, tracing, health checking and authentication. It is also applicable in 
last mile of distributed computing to connect devices, mobile applications and browsers to backend 
services.

gRPC was initially created by Google, which has used a single general-purpose RPC infrastructure 
called _Stubby_ to connect the large number of microservices running within and across its data 
centers for over a decade. In March 2015, Google decided to build the next version of _Stubby_ 
and make it open source. The result was gRPC, which is now used in many organizations outside of 
Google to power use cases from microservices to the “last mile” of computing (mobile, web, and 
Internet of Things).

The "g" in gRPC initially stood for "Google", but it gets 
[replaced in every version](https://github.com/grpc/grpc/blob/master/doc/g_stands_for.md). 

Technically, gRPC is based on HTTP/2, because it uses the features of HTTP/2 like 
 - binary framing
 - header compression (HPACK)
 - multiplexing
 - server push

Like the other APIs documented here, gRPC is designed with an API-first approach. We need
to specify the API with the [_Protocol Buffer Syntax_](https://protobuf.dev/programming-guides/proto3/),
which is a technology and platform neutral interface definition language (IDL).
Here's an example:

```protobuf
syntax = "proto3";
option java_multiple_files = true;
package de.samples.grpc;

message HelloRequest {
    string firstName = 1;
    string lastName = 2;
}

message HelloResponse {
    string greeting = 1;
}

service HelloService {
    rpc hello(HelloRequest) returns (HelloResponse);
}
```

Then, we can use a _Proto Compiler_ that generates stubs for 
[different programming languages](https://grpc.io/docs/languages/) - the same code for both
service provider and service consumer. While the service provider then implements the
service endpoint interface (SEI), the service consumer uses the SEI to invoke the
remote procedures.

Here's an example of a standalone Java server. The Java gRPC library uses Netty as the
HTTP/2 server runtime.

```java
import de.sample.server.HelloServiceImpl;
  
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    final var seiImplementation = new HelloServiceImpl();
    final var server = ServerBuilder
      .forPort(8080)
      .addService(seiImplementation)
      .build(); // Netty
    server.start();
    server.awaitTermination();
  }

}
```

And the corresponding standalone Java client:

```java
import de.sample.generated.stubs.HelloRequest;
import de.sample.generated.stubs.HelloResponse;
import de.sample.generated.stubs.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GrpcClient {

   public static void main(String[] args) throws InterruptedException {
    final var channel = ManagedChannelBuilder
      .forAddress("localhost", 8080)
      .usePlaintext() // no TLS
      .build();
    try {
        final var stub = HelloServiceGrpc
                .newBlockingStub(channel); // non-blocking would also be available
        final var response = stub
          .hello( // remote procedure call
                HelloRequest
                  .newBuilder()
                  .setFirstName("John")
                  .setLastName("Doe")
                  .build()
          );
        // ...
    } finally {
        channel.shutdown();
    }
  }

}

```

## gRPC with Spring Boot

Spring Boot does not have an official support for gRPC, although ProtoBuf is supported since
[Spring Framework 5.1 RC2](https://github.com/spring-projects/spring-framework/issues/20331).

There are several Spring Boot Starters to get a good integration:
 - [https://github.com/LogNet/grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter)
   (only server support)
 - [https://github.com/grpc-ecosystem/grpc-spring](https://github.com/grpc-ecosystem/grpc-spring)
   (support for both client and server - recommended as part of the ecosystem which provides more
   than just the spring integration, e.g. [links to further information](https://github.com/grpc-ecosystem/awesome-grpc))

In this project, we have

- a separate [API Stub Project](../api-stubs/api-stubs-grpc)
  (see [API Spec (Proto File)](../api-stubs/api-stubs-grpc/src/main/proto/blogposts.proto))
- a [Service Provider](../service-provider/docs/GRPC.md)
- a [Service Consumer](../service-consumer-spring/docs/GRPC.md)
