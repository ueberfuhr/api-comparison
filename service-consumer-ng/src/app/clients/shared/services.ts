import {Observable} from 'rxjs';

export interface ClientService<T> {

  get description(): string

  findAll: () => Observable<T[]>;

}
