import {Routes} from '@angular/router';
import {BlogPostDashboardComponent} from './components/blogpost-dashboard/blogpost-dashboard.component';
import {provideRestClient} from '@app/clients/rest';
import {provideGraphQlClient} from '@app/clients/graphql';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'rest',
    pathMatch: 'full'
  },
  {
    path: 'rest',
    component: BlogPostDashboardComponent,
    providers: [
      provideRestClient()
    ]
  },
  {
    path: 'graphql',
    component: BlogPostDashboardComponent,
    providers: [
      provideGraphQlClient()
    ]
  }
];
