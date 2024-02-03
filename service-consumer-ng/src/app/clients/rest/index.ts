import {EnvironmentProviders, Injector, Provider} from '@angular/core';
import {BlogPostDtoMapperService} from './blogpost-dto-mapper.service';
import {RestBlogPostService} from './blogpost.service';
import {BLOGPOST_SERVICE} from '@app/clients';
import {HttpClient, provideHttpClient} from '@angular/common/http';
import {API_ENDPOINT, provideEnvironment} from '@app/environment';

export function provideRestClient(): Provider | EnvironmentProviders[] {
  return [
    provideEnvironment(),
    provideHttpClient(),
    BlogPostDtoMapperService,
    {
      provide: BLOGPOST_SERVICE,
      useFactory: (injector: Injector) => new RestBlogPostService(
        injector.get(HttpClient),
        injector.get(BlogPostDtoMapperService),
        injector.get(API_ENDPOINT)
      ),
      deps: [
        Injector
      ]
    }
  ];
}
