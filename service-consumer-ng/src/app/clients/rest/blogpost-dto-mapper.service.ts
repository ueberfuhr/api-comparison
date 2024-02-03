import {BlogPostDto} from './model';
import {BlogPost} from '@app/shared/domain';

export class BlogPostDtoMapperService {

  mapFromApi(dto: BlogPostDto): BlogPost {
    return {
      id: dto.id,
      title: dto.title,
      content: dto.content,
      tags: []
    }
  }

}
