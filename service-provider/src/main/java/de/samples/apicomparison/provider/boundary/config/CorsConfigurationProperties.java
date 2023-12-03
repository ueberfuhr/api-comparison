package de.samples.apicomparison.provider.boundary.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("web.cors.allowed")
@Getter
@Setter
public class CorsConfigurationProperties {

    private String[] origins = { "*" };
    private boolean credentials = false;

}
