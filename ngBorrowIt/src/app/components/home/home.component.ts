import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

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
    private productService: ProductService

  ) { }

  ngOnInit(): void {
  }

}
