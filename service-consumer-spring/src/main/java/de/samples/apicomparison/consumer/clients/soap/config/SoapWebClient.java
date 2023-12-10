package de.samples.apicomparison.consumer.clients.soap.config;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Qualifier
@Inherited
@Documented
public @interface SoapWebClient {

}
