package de.samples.apicomparison.provider.boundary.graphql;

import de.samples.apicomparison.provider.domain.NotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class QlGlobalExceptionHandler extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof NotFoundException notFoundException) {
      return GraphqlErrorBuilder.newError()
        .errorType(ErrorType.NOT_FOUND)
        .message(notFoundException.getMessage() == null ? "Item could not be found." : notFoundException.getMessage())
        .path(env.getExecutionStepInfo().getPath())
        .location(env.getField().getSourceLocation())
        .build();
    }
    return super.resolveToSingleError(ex, env);
  }
}
