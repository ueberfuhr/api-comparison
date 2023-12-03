package de.samples.apicomparison.provider.boundary.rest.api;

import java.lang.annotation.*;

/**
 * Annotate a controller to add the <tt>/api/v1</tt> url prefix.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface V1Api {
}
