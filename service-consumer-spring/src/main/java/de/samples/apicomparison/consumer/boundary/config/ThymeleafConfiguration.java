package de.samples.apicomparison.consumer.boundary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
public class ThymeleafConfiguration {

  @Autowired
  void configureThymeleafEngine(SpringTemplateEngine engine) { // for both Mvc and WebFlux
    engine.addDialect(new Java8TimeDialect());
  }

}
