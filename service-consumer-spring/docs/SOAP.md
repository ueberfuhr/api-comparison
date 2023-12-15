# Simple Object Access Protocol (SOAP) - Spring Boot Service Consumer

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

**Unfortunately, this only supports Spring WebMVC, while we want to use WebFlux in the service consumer project.** For this, we need to
- exclude tomcat from the Spring Webservices Starter dependency (we would just need a JAX-B dependency)
- use the Reactive WebClient to encode and decode SOAP messages

So the following steps were made:
- Copy the [BlogPostService WSDL](../src/main/resources/soap/blogPostService.wsdl)
- Generate Java code by using the [JAX-WS Maven Plugin](https://www.mojohaus.org/jaxws-maven-plugin/)
  and by specifying a [binding file](../src/main/resources/soap/wsimport.xjb) to customize code generation (e.g. package names)
- [customize the WebClient](../src/main/java/de/samples/apicomparison/consumer/clients/soap/config/SoapWebClientConfiguration.java) 
  by specifying a custom encoder and decoder to create and parse SOAP envelopes
- implement the [SOAP Client](../src/main/java/de/samples/apicomparison/consumer/clients/soap/BlogPostSoapClient.java)
  - we have a [HttpSoapClient](../src/main/java/de/samples/apicomparison/consumer/clients/soap/HttpSoapClient.java) class
    to simplify SOAP calls to the WebClient and to use injection-by-type which is better that injection-by-qualifier in combination with Lombok's `@RequiredArgsConstructor`
