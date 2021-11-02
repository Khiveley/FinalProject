import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { subscribeOn } from 'rxjs/operators';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = "BorrowIt";

  products: Product[] = [];

  selected: Product | null = null;
  newProduct: Product = new Product();
  editProduct: Product | null = null;


  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

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

}
