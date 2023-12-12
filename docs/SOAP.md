# Simple Object Access Protocol (SOAP)

## General Facts

SOAP (Simple Object Access Protocol) is a standards-based web services access protocol 
that has been around for a long time. Originally developed by Microsoft, SOAP isn’t as 
simple as the acronym would suggest.

To be more precise, SOAP is not a protocol, it is more of a message format that can be
transferred by the usage of an underlying protocol (mostly HTTP). This format is standardized
by the W3C and is called a _SOAP envelope_.

```xml
<soapenv:Envelope
  xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
  <soapenv:Header/>
  <soapenv:Body>
    <!-- the payload -->
  </soapenv:Body>
</soapenv:Envelope>
```

[BlogPostService sample requests](../sample-requests/soap)

There is a _SOAP over HTTP_ binding that determines how SOAP messages are transferred via HTTP:
 - use `POST` only (no matter what kind of operation is called)
 - use one single resource URL only
 - optionally, use a `SOAPAction` header to distinguish SOAP requests from other HTTP requests
There are other bindings for other protocols too.

Which operation is called can be determined by the payload or by the `SOAPAction` header.
The response is also a SOAP envelope. The payload is specified by the _Web Services Description Language (WSDL)_,
which we can understand as an extension of _XML Schema Descriptions (XSD)_.

[BlogPostService WSDL](../service-provider/src/main/resources/soap/blogPostService.wsdl)

## Examples

One example is the _eXTra-Standard_. The eXTra transport process is an open and freely available standard 
for data exchange, which was developed jointly by business and administration under the leadership of the 
[AWV](https://www.awv-net.de/) on the basis of existing processes. It is equally suitable for existing and 
new data exchange methods in a variety of environments and topologies. eXTra supports the migration of existing 
transport procedures and thereby promotes standardization and consolidation in the area of external and internal 
communication. eXTra is technology and network neutral.

[Homepage](https://www.extra-standard.de/) | [GitHub](https://github.com/extra-standard)

## SOAP with Spring Boot

SOAP services are supported by the [_Spring Web Services_ project](https://spring.io/projects/spring-ws).
It provides XML support (e.g. JAX-B and JAX-P) and integrates with both WS-Security and Spring Security. 
One restriction is the missing support of Spring WebFlux.

### Service Provider

The following steps were made in the service provider project:
 - Specify the [BlogPostService WSDL](../service-provider/src/main/resources/soap/blogPostService.wsdl)
 - Generate Java code by using the [JAX-WS Maven Plugin](https://www.mojohaus.org/jaxws-maven-plugin/)
     - Spring does not support JAX-WS, but we can use the generated stubs
     - in the sample project, we do not invoke this within the context of the Maven build lifecycle, we just call it manually
       (`mvn jaxws:wsimport`) and store the generated sources in the Git repository
     - we use a [binding file](../service-provider/src/main/resources/soap/wsimport.xjb) to customize code generation (e.g. package names)
 - Registers Spring's `org.springframework.ws.transport.http.MessageDispatcherServlet` and also make the WSDL available per URL
   (see [`SoapConfiguration`](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/soap/config/SoapConfiguration.java))
 - implement the [SOAP Controller](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/soap/BlogPostSoapController.java)
   - implement the generated [Service Endpoint Interface (SEI)](../service-provider/src/main/java/de/samples/apicomparison/provider/boundary/soap/stub/service/BlogPostServiceInterface.java)
     (not necessary, but helpful to get WSDL changes tracked)
   - add annotations to map the service methods to the payload (`@PayloadRoot` is the SOAP analogy to `@RequestMapping`)

### Service Consumer

To implement a service consumer, Spring Webservices would support us by extending from the superclass
`org.springframework.ws.client.core.support.WebServiceGatewaySupport`, which would provide us a template
to access a SOAP service easily:

```java
public class CountryClient extends WebServiceGatewaySupport {

  public GetCountryResponse getCountry(String country) {

    GetCountryRequest request = new GetCountryRequest();
    request.setName(country);
    return (GetCountryResponse) getWebServiceTemplate()
        .marshalSendAndReceive(
          "http://localhost:8080/ws/countries", 
          request,
          new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest")
        );
  }

}
```

** Unfortunately, this only supports Spring WebMVC, while we want to use WebFlux in the service consumer project. For this, we need to
- exclude tomcat from the Spring Webservices Starter dependency (we would just need a JAX-B dependency)
- use the Reactive WebClient to encode and decode SOAP messages

So the following steps were made:
- Copy the [BlogPostService WSDL](../service-consumer-spring/src/main/resources/soap/blogPostService.wsdl)
- Generate Java code by using the [JAX-WS Maven Plugin](https://www.mojohaus.org/jaxws-maven-plugin/)
  and by specifying a [binding file](../service-consumer-spring/src/main/resources/soap/wsimport.xjb) to customize code generation (e.g. package names)
- [customize the WebClient](../service-consumer-spring/src/main/java/de/samples/apicomparison/consumer/clients/soap/config/SoapWebClientConfiguration.java) 
  by specifying a custom encoder and decoder to create and parse SOAP envelopes
- implement the [SOAP Client](../service-consumer-spring/src/main/java/de/samples/apicomparison/consumer/clients/soap/BlogPostSoapClient.java)
  - we have a [HttpSoapClient](../service-consumer-spring/src/main/java/de/samples/apicomparison/consumer/clients/soap/HttpSoapClient.java) class
    to simplify SOAP calls to the WebClient and to use injection-by-type which is better that injection-by-qualifier in combination with Lombok's `@RequiredArgsConstructor`
