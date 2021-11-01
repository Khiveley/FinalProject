import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  private baseUrl = 'http://localhost:8091/api/users'


  getHttpOptions(){
    let credentials = this.authService.getCredentials();
    let options = {
      headers: {
        'X-Requested-With': 'XMLHttpRequest',
        'Authorization': `Basic ${credentials}`
      }
    };
    return options;
  }

    index(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('UserService.index(): error retrieving developers');
      })
    );
  }

  show(username: string): Observable<User>{
    return this.http.get<User>('http://localhost:8091/api/user/'+username, this.getHttpOptions()).pipe(
      catchError((err:any) => {
        console.log(err);
        return throwError('UserService.show(): error retrieving user')
      })
    );
  }
  create(user: User): Observable<User> {
    user.email = '';
    user.username = '';
    user.password = '';
    user.enabled = false;
    user.role = '';
      return this.http.post<User>(this.baseUrl, user, this.getHttpOptions()).pipe(
        catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.create(): Error creating Todo');
      })
    );
  }

    update(user: User) {

      return this.http.put<User>(`${this.baseUrl}/${user.id}`, user, this.getHttpOptions()).pipe(
        catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.update(): Error updating Todo');
      })
    );
    }

    destroy(id: number) {
      return this.http.delete(`${this.baseUrl}/${id}`, this.getHttpOptions()).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('TodoService.destroy(): Error deleting Todo with Id');
        })
        );

      }
    }
