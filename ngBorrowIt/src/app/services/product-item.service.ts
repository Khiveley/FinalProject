import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Product } from '../models/product';
import { Productitem } from '../models/productitem';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class ProductItemService {
  private baseUrl = 'http://localhost.8091/';
  private url = environment.baseUrl + 'api/productitems';

  constructor(private http: HttpClient,
    private datePipe: DatePipe,
    private authService: AuthService
    ) {}

  index(): Observable<Productitem[]> {
    return this.http.get<Productitem[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          'ProductItemService.index(): Error retrieving Product Item list'
        );
      })
    );
  }

  show(productId: number): Observable<Productitem> {
    return this.http.get<Productitem>(this.url + '/' + productId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          'ProductItemService.show(): Error retrieving Product item show'
        );
      })
    );
  }

  create(productItem: Productitem): Observable<Productitem> {
    console.log('adding product item');
    return this.http.post<Productitem>(this.url, productItem, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          'ProductItemService.create(): Error creating product item'
        );
      })
    );
  }

  update(productItem: Productitem) {
    return this.http
      .put<Product>(`${this.url}/${productItem.id}`, productItem)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            'ProductItemService.update(): Error updating Product'
          );
        })
      );
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          'ProductItemService.delete(): error deleting product with id' + id
        );
      })
    );
  }
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
}
