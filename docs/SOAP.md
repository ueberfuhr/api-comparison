# Simple Object Access Protocol (SOAP)

## Basics

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

[BlogPostService WSDL](../api-stubs/api-stubs-soap/src/main/resources/blogPostService.wsdl)

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

In this project, we have

- a separate [API Stub Project](../api-stubs/api-stubs-soap)
  (see [API Spec (WSDL File)](../api-stubs/api-stubs-soap/src/main/resources/blogPostService.wsdl))
- a [Service Provider](../service-provider/docs/SOAP.md)
- a [Service Consumer](../service-consumer-spring/docs/SOAP.md)
