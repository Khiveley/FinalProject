import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = "BorrowIt";

  products: Product[] = [];

  selected: Product | null = null;
  // newProduct: Product | null = new Product();
  editProduct: Product | null = null;

  constructor() { }

  ngOnInit(): void {
  }

}
