# Simple Object Access Protocol (SOAP) - Spring Boot Service Provider

The following steps were made in the service provider project:
- declare a dependency to the [API Stubs](../../api-stubs/api-stubs-soap)
 - Registers Spring's `org.springframework.ws.transport.http.MessageDispatcherServlet` and also make the WSDL available per URL
   (see [`SoapConfiguration`](../src/main/java/de/samples/apicomparison/provider/boundary/soap/config/SoapConfiguration.java))
 - implement the [SOAP Controller](../src/main/java/de/samples/apicomparison/provider/boundary/soap/BlogPostSoapController.java)
   - implement the generated [Service Endpoint Interface (SEI)](../src/main/java/de/samples/apicomparison/provider/boundary/soap/stub/service/BlogPostServiceInterface.java)
     (not necessary, but helpful to get WSDL changes tracked)
   - add annotations to map the service methods to the payload (`@PayloadRoot` is the SOAP analogy to `@RequestMapping`)
