import {EnvironmentProviders, Injector, Provider} from '@angular/core';
import {API_ENDPOINT, provideEnvironment} from '@app/environment';
import {provideHttpClient} from '@angular/common/http';
import {BLOGPOST_SERVICE} from '@app/clients';
import {GraphQlBlogPostService} from './blogpost.service';

export function provideGraphQlClient(): Provider | EnvironmentProviders[] {
  return [
    provideEnvironment(),
    provideHttpClient(),
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
