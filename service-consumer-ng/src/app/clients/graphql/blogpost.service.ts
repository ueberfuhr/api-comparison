import {Inject} from '@angular/core';
import {API_ENDPOINT} from '@app/environment';
import {BlogPostService} from '@app/clients';
import {EMPTY, Observable} from 'rxjs';
import {BlogPost} from '@app/shared/domain';

export class GraphQlBlogPostService implements BlogPostService {

  constructor(
    @Inject(API_ENDPOINT) private readonly apiEndpoint: string
  ) {
  }

  get description(): string {
    return 'Read Blog Posts by calling the GraphQL API.';
  }


  findAll(): Observable<BlogPost[]> {
    return EMPTY;
  }


}
