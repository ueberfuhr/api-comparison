package de.samples.apicomparison.consumer.clients.soap.config.encoding;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Holder for {@link JAXBContext} instances.
 *
 * @author Arjen Poutsma
 * @since 5.0
 */
final class JaxbContextContainer {

  private final ConcurrentMap<Class<?>, JAXBContext> jaxbContexts = new ConcurrentHashMap<>(64);

  public JAXBContext getJaxbContext(Class<?> clazz) throws JAXBException {
    Assert.notNull(clazz, "Class must not be null");
    JAXBContext jaxbContext = this.jaxbContexts.get(clazz);
    if (jaxbContext == null) {
      jaxbContext = JAXBContext.newInstance(clazz);
      this.jaxbContexts.putIfAbsent(clazz, jaxbContext);
    }
    return jaxbContext;
  }

}
