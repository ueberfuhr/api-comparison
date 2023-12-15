package de.samples.apicomparison.provider.boundary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IndexPageConfiguration {

  @Bean
  public WebMvcConfigurer indexPageConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addViewControllers(
        @SuppressWarnings("NullableProblems")
        ViewControllerRegistry registry
      ) {
        registry
          .addViewController("/")
          .setViewName("redirect:/index.html");
      }
    };
  }

}
