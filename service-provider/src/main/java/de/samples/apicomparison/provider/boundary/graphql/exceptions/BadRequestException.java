package de.samples.apicomparison.provider.boundary.graphql.exceptions;

import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class BadRequestException extends RuntimeException implements GraphQLError {

  private String message = "Bad request";
  private List<SourceLocation> locations;

  public BadRequestException(String message, List<SourceLocation> locations) {
    this.message = message;
    this.locations = locations;
  }

  @Override
  public Map<String, Object> getExtensions() {
    Map<String, Object> customAttributes = new LinkedHashMap<>();
    customAttributes.put("errorCode", HttpStatus.BAD_REQUEST.value());
    return customAttributes;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return locations;
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.BAD_REQUEST;
  }

  @Override
  public Map<String, Object> toSpecification() {
    return GraphQLError.super.toSpecification();
  }

}
