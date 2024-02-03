import {EnvironmentProviders, Injector, Provider} from '@angular/core';
import {API_ENDPOINT, provideEnvironment} from '@app/environment';
import {BLOGPOST_SERVICE} from '@app/clients';
import {GraphQlBlogPostService} from './blogpost.service';

export function provideGraphQlClient(): Provider | EnvironmentProviders[] {
  return [
    provideEnvironment(),
    {
      provide: BLOGPOST_SERVICE,
      useFactory: (injector: Injector) => new GraphQlBlogPostService(
        injector.get(API_ENDPOINT)
      ),
      deps: [
        Injector
      ]
    }
  ];
}
