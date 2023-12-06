package de.samples.apicomparison.provider.boundary.graphql.scalars;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;

@Configuration
public class DateScalarConfiguration {

  @Bean
  RuntimeWiringConfigurer registerDateScalar() {
    return builder -> builder
      .scalar(
        GraphQLScalarType
          .newScalar()
          .name("Date")
          .description("Java LocalDate scalar")
          .coercing(new DateScalar())
          .build()
      );
  }

  private static class DateScalar implements Coercing<LocalDate, String> {

    @SuppressWarnings("NullableProblems")
    @Override
    public String serialize(
      Object dataFetcherResult,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingSerializeException {
      if (dataFetcherResult instanceof LocalDate date) {
        return date.toString(); // ISO-8601 format yyyy-MM-dd
      } else {
        throw new CoercingSerializeException("Expected a LocalDate object.");
      }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public LocalDate parseValue(
      Object input,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingParseValueException {
      try {
        if (input instanceof String s) {
          return LocalDate.parse(s);
        } else {
          throw new CoercingParseValueException("Expected a String");
        }
      } catch (DateTimeParseException e) {
        throw new CoercingParseValueException(String.format("Not a valid date: '%s'.", input), e);
      }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public LocalDate parseLiteral(
      Value<?> input,
      CoercedVariables variables,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingParseLiteralException {
      if (input instanceof StringValue s) {
        return parseValue(s.getValue(), graphQLContext, locale);
      } else {
        throw new CoercingParseLiteralException("Expected a StringValue.");
      }
    }

  }

}
