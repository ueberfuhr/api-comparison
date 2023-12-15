# Simple Object Access Protocol (SOAP) - Spring Boot Service Provider

The following steps were made in the service provider project:
 - Specify the [BlogPostService WSDL](../src/main/resources/soap/blogPostService.wsdl)
 - Generate Java code by using the [JAX-WS Maven Plugin](https://www.mojohaus.org/jaxws-maven-plugin/)
     - Spring does not support JAX-WS, but we can use the generated stubs
     - in the sample project, we do not invoke this within the context of the Maven build lifecycle, we just call it manually
       (`mvn jaxws:wsimport`) and store the generated sources in the Git repository
     - we use a [binding file](../src/main/resources/soap/wsimport.xjb) to customize code generation (e.g. package names)
 - Registers Spring's `org.springframework.ws.transport.http.MessageDispatcherServlet` and also make the WSDL available per URL
   (see [`SoapConfiguration`](../src/main/java/de/samples/apicomparison/provider/boundary/soap/config/SoapConfiguration.java))
 - implement the [SOAP Controller](../src/main/java/de/samples/apicomparison/provider/boundary/soap/BlogPostSoapController.java)
   - implement the generated [Service Endpoint Interface (SEI)](../src/main/java/de/samples/apicomparison/provider/boundary/soap/stub/service/BlogPostServiceInterface.java)
     (not necessary, but helpful to get WSDL changes tracked)
   - add annotations to map the service methods to the payload (`@PayloadRoot` is the SOAP analogy to `@RequestMapping`)
