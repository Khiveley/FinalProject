import { Component, OnInit } from '@angular/core';
import { Product } from './models/product';
import { ProductService } from 'src/app/services/product.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
    let productIdString = this.route.snapshot.paramMap.get('id');
    if(productIdString){
      let productId = Number.parseInt(productIdString);
      if(!isNaN(productId)){
        this.productService.show(productId).subscribe(
          (product) => {
            this.reloadProducts();
            this.selected = product;
          },
          (error) => {
            console.error('Invalid Product Id' + productId);
            this.router.navigateByUrl('notfound');
          }
        );
      } else {
        console.error('Invalid Product ID' + productId);
        this.router.navigateByUrl('notfound');
      }
    }
    this.reloadProducts();
  }

  reloadProducts(): void {
    this.productService.index().subscribe(
      (products) => {
        this.products = products;
      },
      (error) => {
        console.error('Error retrieving products');
        console.error(error);
      }
    );
  }

  title = 'ngBorrowIt';

  products: Product[] = [ ];

  selected: Product | null = null;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  displayProduct(product: Product): void {
    this.selected = product;
  }

  displayTable(): void {
    this.selected = null;
  }

}

