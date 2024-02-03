import {BlogPost} from '@app/shared/domain';
import {idFromDomainObject} from './_utilities';
import {ClientService} from './services';
import {InjectionToken} from '@angular/core';

export interface BlogPostService extends ClientService<BlogPost> {
}

export type BlogPostIdentifier = BlogPost | string;

export function idFromBlogPost(blogPost: BlogPostIdentifier): string | undefined {
  return idFromDomainObject<BlogPost, string>(
    blogPost,
    o => typeof o === "string",
    o => o.id
  );
}

export const BLOGPOST_SERVICE
  = new InjectionToken<BlogPostService>('services.client.blogpost')
