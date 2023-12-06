package de.samples.apicomparison.consumer.clients.rest.config.util;

import org.springframework.core.annotation.MergedAnnotation;

public interface PackageResolver {
  String[] getPackageNames(MergedAnnotation<?> annotation, String className);
}
