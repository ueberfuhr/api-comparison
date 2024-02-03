import {Inject} from '@angular/core';
import {API_ENDPOINT} from '@app/environment';
import {HttpClient} from '@angular/common/http';
import {BlogPostIdentifier, BlogPostService, idFromBlogPost} from '@app/clients';
import {map, Observable} from 'rxjs';
import {BlogPost} from '@app/shared/domain';
import {BlogPostDtoMapperService} from './blogpost-dto-mapper.service';
import {BlogPostDto} from './model';

export class RestBlogPostService implements BlogPostService {

  constructor(
    private readonly httpClient: HttpClient,
    private readonly mapper: BlogPostDtoMapperService,
    @Inject(API_ENDPOINT) private readonly apiEndpoint: string
  ) {
  }

  get description(): string {
    return 'Read Blog Posts by calling the REST API.';
  }


  private endpoint(blogPost?: BlogPostIdentifier): string {
    return `${this.apiEndpoint}/blogposts` + (blogPost ? `/${idFromBlogPost(blogPost)}` : '')
  }

  findAll(): Observable<BlogPost[]> {
    return this.httpClient
      .get<BlogPostDto[]>(this.endpoint())
      .pipe(
        map(
          payload => payload.map(
            dto => this.mapper.mapFromApi(dto)
          )
        )
      );
  }


}
