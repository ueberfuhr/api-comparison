package de.samples.apicomparison.consumer.clients.graphql.config;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Qualifier
@Inherited
@Documented
public @interface GraphQlWebClient {

}
