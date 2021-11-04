import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Product } from '../models/product';
import { DatePipe} from '@angular/common';
import { environment} from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  // private baseUrl = 'http://localhost.8091/';
  private url = environment.baseUrl + 'api/products';

  constructor(
    private http: HttpClient,
    private datePipe: DatePipe,
    private authService: AuthService
  ) { }

  index(): Observable<Product[]>{
    return this.http.get<Product[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.index(): Error retrieving Product list');
      })
    );
  }

  getCategories(): Observable<Category[]>{
    return this.http.get<Category[]>(environment.baseUrl + 'api/category', this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.getCategories(): Error retrieving Category list');
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
    return this.http.post<Product>(this.url, product,this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ProductService.create(): Error creating product');
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
