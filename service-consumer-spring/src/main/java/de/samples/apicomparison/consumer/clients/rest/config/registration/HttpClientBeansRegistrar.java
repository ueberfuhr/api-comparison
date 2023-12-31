package de.samples.apicomparison.consumer.clients.rest.config.registration;

import de.samples.apicomparison.consumer.clients.rest.config.EnableHttpClients;
import de.samples.apicomparison.consumer.clients.rest.config.util.DefaultPackageResolver;
import de.samples.apicomparison.consumer.clients.rest.config.util.PackageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Annotation;
import java.util.function.Function;

@RequiredArgsConstructor
public class HttpClientBeansRegistrar implements ImportBeanDefinitionRegistrar {

  private final PackageResolver packageResolver;
  private final Class<? extends Annotation> annotationType;
  private final Function<BeanDefinitionRegistry, ClassPathBeanDefinitionScanner> scanner;

  @SuppressWarnings("unused")
  public HttpClientBeansRegistrar() {
    this(
      new DefaultPackageResolver(),
      EnableHttpClients.class,
      HttpClientBeanDefinitionScanner::new
    );
  }

  @Override
  public void registerBeanDefinitions(
    AnnotationMetadata configMetadata,
    @SuppressWarnings("NullableProblems")
    BeanDefinitionRegistry registry
  ) {
    final var className = configMetadata.getClassName();
    configMetadata
      .getAnnotations()
      .stream(annotationType)
      .forEach(annotation -> handleAnnotation(registry, annotation, className));
  }

  private void handleAnnotation(BeanDefinitionRegistry registry, MergedAnnotation<? extends Annotation> annotation, String className) {
    final var packageNames = packageResolver.getPackageNames(annotation, className);
    scanner
      .apply(registry)
      .scan(packageNames);
  }

}
