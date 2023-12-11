package de.samples.apicomparison.consumer.clients.soap.config.encoding;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.UnmarshalException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;
import org.springframework.core.codec.CodecException;
import org.springframework.core.codec.DecodingException;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.lang.Nullable;
import org.springframework.util.MimeType;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.support.DefaultStrategiesHelper;
import reactor.core.Exceptions;

import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayOutputStream;
import java.util.Map;

@Slf4j
public class Jaxb2SoapDecoder extends Jaxb2XmlDecoder {

  private final JaxbContextContainer jaxbContexts = new JaxbContextContainer();

  @SuppressWarnings("NullableProblems")
  @Override
  public Object decode(
    DataBuffer dataBuffer,
    ResolvableType targetType,
    @Nullable MimeType mimeType,
    @Nullable Map<String, Object> hints
  ) throws DecodingException {

    try {
      DefaultStrategiesHelper helper = new DefaultStrategiesHelper(WebServiceTemplate.class);
      WebServiceMessageFactory messageFactory = helper.getDefaultStrategy(WebServiceMessageFactory.class);
      WebServiceMessage message = messageFactory.createWebServiceMessage(dataBuffer.asInputStream());
      if (log.isDebugEnabled()) {
        final ByteArrayOutputStream loggerOutput = new ByteArrayOutputStream();
        message.writeTo(loggerOutput);
        log.debug("Received SOAP request: \n{}", loggerOutput);
      }
      return unmarshal(message, targetType.toClass());
    } catch (Exception ex) {
      throw Exceptions.propagate(ex.getCause() instanceof XMLStreamException xe ? xe : ex);
    } finally {
      DataBufferUtils.release(dataBuffer);
    }
  }

  private <T> T unmarshal(WebServiceMessage message, Class<T> bodyClass) {
    try {
      final var unmarshaller = initUnmarshaller(bodyClass);
      final var jaxbElement = unmarshaller.unmarshal(
        message.getPayloadSource(),
        bodyClass
      );
      return jaxbElement.getValue();
    } catch (UnmarshalException ex) {
      throw new DecodingException("Could not unmarshal XML", ex);
    } catch (JAXBException ex) {
      throw new CodecException("Invalid JAXB configuration", ex);
    }
  }

  private Unmarshaller initUnmarshaller(Class<?> outputClass) throws CodecException, JAXBException {
    final var unmarshaller = this.jaxbContexts
      .getJaxbContext(outputClass)
      .createUnmarshaller();
    return getUnmarshallerProcessor()
      .apply(unmarshaller);
  }

}
