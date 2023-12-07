package de.samples.apicomparison.consumer.clients.rest.config.registration;

import de.samples.apicomparison.consumer.clients.rest.config.HttpClient;
import de.samples.apicomparison.consumer.clients.rest.config.RestWebClientConfiguration;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class HttpClientBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
  public HttpClientBeanDefinitionScanner(BeanDefinitionRegistry registry) {
    super(registry, false);
    addIncludeFilter(new AnnotationTypeFilter(HttpClient.class));
    // maybe, we could configure a custom BeanNameGenerator
  }

  @Override
  protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
    AnnotationMetadata metadata = beanDefinition.getMetadata();
    return metadata.isInterface() && !metadata.isAnnotation();
  }

  @Override
  protected void postProcessBeanDefinition(
    AbstractBeanDefinition beanDefinition,
    @SuppressWarnings("NullableProblems")
    String beanName
  ) {

    beanDefinition.setBeanClassName(HttpClientFactoryBean.class.getName());

    beanDefinition
      .getConstructorArgumentValues()
      .addGenericArgumentValue(((AnnotatedBeanDefinition) beanDefinition).getMetadata());

    beanDefinition.setDependsOn(RestWebClientConfiguration.REST_WEBCLIENT_BEAN_NAME);

  }

}
