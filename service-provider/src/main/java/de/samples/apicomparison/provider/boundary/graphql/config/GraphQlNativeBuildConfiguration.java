package de.samples.apicomparison.provider.boundary.graphql.config;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(GraphQlNativeBuildConfiguration.GraphQlRuntimeHints.class)
@Configuration
public class GraphQlNativeBuildConfiguration {

    static class GraphQlRuntimeHints implements RuntimeHintsRegistrar {

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources()
              .registerPattern("graphql/**/")
              .registerPattern("graphiql/index.html");
        }
    }

}
