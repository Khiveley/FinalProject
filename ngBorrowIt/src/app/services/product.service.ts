import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Product } from '../models/product';
import { DatePipe} from '@angular/common';
import { environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost.8091/';
  private url = environment.baseUrl + 'api/products';

  constructor(
    private http: HttpClient,
    private datePipe: DatePipe,
  ) { }

  index(): Observable<Product[]>{
    return this.http.get<Product[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.index(): Error retrieving Product list');
      })
    );
  }

  show(productId: number): Observable<Product> {
    return this.http.get<Product>(this.url + '/' + productId).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.show(): Error retrieving Product show');
      })
    );
  }

  create(product: Product): Observable<Product> {
    console.log('adding product');
    return this.http.post<Product>(this.url, product).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.create(): Error creating product');
      })
    );

  }

  update(product: Product) {
    return this.http.put<Product>(`${this.url}/${product.id}`, product).pipe(
      catchError((err: any)=>{
        console.log(err);
        return throwError('ProductService.update(): Error updating Product');
      })
      );
  }

  delete(id: number){
    return this.http.delete(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.delete(): error deleting product with id' + id);
      })
    )
  }
}
