import {EnvironmentProviders, makeEnvironmentProviders} from '@angular/core';
import {API_ENDPOINT} from './environment.model';
import {environment} from './environment';
import {Environment} from '@angular/cli/lib/config/workspace-schema';

export function provideEnvironment(): EnvironmentProviders {
  return makeEnvironmentProviders([
    {
      provide: API_ENDPOINT,
      useValue: environment.apiEndpoint
    },
    {
      provide: Environment,
      useValue: environment
    }
  ])
}
