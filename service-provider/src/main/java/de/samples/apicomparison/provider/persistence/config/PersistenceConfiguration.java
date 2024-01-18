package de.samples.apicomparison.provider.persistence.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // enable update timestamp
public class PersistenceConfiguration {
}
