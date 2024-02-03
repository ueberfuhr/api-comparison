import {Component, Inject} from '@angular/core';
import {BLOGPOST_SERVICE, BlogPostService} from '@app/clients';
import {AsyncPipe} from '@angular/common';

@Component({
  selector: 'app-blogpost-dashboard',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  template: `
    BlogPostDashboard component: {{ description }}
    <br/>
    @for (bp of blogposts$ | async; track bp.id) {
      <div>{{bp.title}}</div>
    }
  `
})
export class BlogPostDashboardComponent {

  readonly blogposts$ = this.blogPostService.findAll();

  constructor(
    @Inject(BLOGPOST_SERVICE) private readonly blogPostService: BlogPostService
  ) {
  }

  get description() {
    return this.blogPostService.description;
  }

}
