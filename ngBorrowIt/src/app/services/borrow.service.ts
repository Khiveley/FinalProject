import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Borrow } from '../models/borrow';
import { Productitem } from '../models/productitem';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class BorrowService {
  // private baseUrl = 'http://localhost:8086/';

  private url = environment.baseUrl + 'api/borrows';

  constructor(
    private http: HttpClient,
    private datePipe: DatePipe,
    private auth: AuthService
  ) {}

  index(): Observable<Borrow[]> {
    return this.http.get<Borrow[]>(this.url, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          'BorrowService.index(): Error retrieving borrow list'
        );
      })
    );
  }

  show(borrowId: number): Observable<Borrow> {
    return this.http
      .get<Borrow>(this.url + '/' + borrowId, this.getHttpOptions())
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('BorrowService.show(): Error retrieving borrow');
        })
      );
  }
  create(productitem: Productitem | null): Observable<Borrow> {
    return this.http.post<Borrow>(this.url, productitem, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('BorrowService.create(): Error creating borrow');
      })
    );
  }

  update(borrow: Borrow) {
    return this.http
      .put<Borrow>(`${this.url}/${borrow.id}`, borrow, this.getHttpOptions())
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('BorrowService.update(): Error creating borrow');
        })
      );
  }

  // this.editTodo = null;

  destroy(id: number) {
    return this.http.delete(`${this.url}/${id}`, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          'BorrowService.destory(): Error deleting borrow item'
        );
      })
    );
  }

  getHttpOptions() {
    let credentials = this.auth.getCredentials();
    let options = {
      headers: {
        'X-Requested-With': 'XMLHttpRequest',
        Authorization: `Basic ${credentials}`,
      },
    };
    return options;
  }
}
