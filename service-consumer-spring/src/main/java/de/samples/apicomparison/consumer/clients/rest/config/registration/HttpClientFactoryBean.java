package de.samples.apicomparison.consumer.clients.rest.config.registration;

import de.samples.apicomparison.consumer.clients.rest.config.RestWebClientConfiguration;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class HttpClientFactoryBean implements FactoryBean<Object>, BeanFactoryAware {

  private final Class<?> objectType;
  @Setter
  private BeanFactory beanFactory;

  public HttpClientFactoryBean(AnnotationMetadata metadata) {
    this.objectType = ClassUtils.resolveClassName(metadata.getClassName(), null);
  }

  @Override
  public Object getObject() {
    final var webClient = beanFactory.getBean(
      RestWebClientConfiguration.REST_WEBCLIENT_BEAN_NAME,
      WebClient.class
    );
    final var adapter = WebClientAdapter.create(webClient);
    final var factory = HttpServiceProxyFactory
      .builderFor(adapter)
      .build();
    return factory.createClient(this.objectType);
  }

  @Override
  public Class<?> getObjectType() {
    return this.objectType;
  }
}
