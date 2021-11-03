import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { subscribeOn } from 'rxjs/operators';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { Productitem } from 'src/app/models/productitem';
import { ProductService } from 'src/app/services/product.service';
import { ProductItemService } from 'src/app/services/product-item.service';
import { Router } from '@angular/router';
import { normalizeGenFileSuffix } from '@angular/compiler/src/aot/util';
import { BorrowService } from 'src/app/services/borrow.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  title = 'BorrowIt';

  products: Product[] = [];

  selected: Product | null = null;
  selectedProductItem: Productitem | null = null;
  newProduct: Product = new Product();
  editProduct: Product | null = null;
  editProductItem: Product | undefined;
  productItems: Productitem[] | null = [];
  newProductItem: Productitem = new Productitem();

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
    private productItemService: ProductItemService,
    private borrowService: BorrowService
  ) {}

  ngOnInit(): void {
    let productIdString = this.route.snapshot.paramMap.get('id');
    if (productIdString) {
      let productId = Number.parseInt(productIdString);
      if (!isNaN(productId)) {
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

  displayProduct(product: Product): void {
    this.selected = product;
  }

  displayTable(): void {
    this.selected = null;
  }

  addProduct(product: Product) {
    this.productService.create(product).subscribe(
      (newProduct) => {
        console.log('ProductList.addProduct(): product created successfully');
        this.reloadProducts();
        this.newProduct = new Product();
      },
      (err) => {
        console.error('ProductList.addProduct(): Error creating Product');
        console.error(err);
      }
    );
  }

  setEditProduct(): void {
    this.editProduct = Object.assign({}, this.selected);
  }

  updateProduct(product: Product, showProduct = true): void {
    this.productService.update(product).subscribe(
      (updated) => {
        this.reloadProducts();
        this.editProduct = null;
        if (showProduct) {
          this.selected = updated;
        }
        this.selected = updated;
      },

      (failure) => {
        console.error(
          'ProductListComponent.updateProduct(): error updating product'
        );
        console.error(failure);
      }
    );
  }

  deleteProduct(id: number): void {
    // this.todoService.destroy(id);
    this.productService.delete(id).subscribe(
      (success) => {
        this.reloadProducts();
      },
      (failure) => {
        console.error(
          'ProductListComponent.deleteProduct(): error deleting product'
        );
        console.error(failure);
      }
    );
  }

  setEditProductItem(): void {
    this.editProductItem = Object.assign({}, this.selected);
  }

  addProductItem(productitem: Productitem) {
    this.productItemService.create(productitem).subscribe(
      (newProductitem) => {
        console.log(
          'ProductItemList.addProductItem(): product item created successfully'
        );
        this.reloadProductItems();
        this.newProductItem = new Productitem();
      },
      (err) => {
        console.error('ProductList.addProduct(): Error creating Product');
        console.error(err);
      }
    );
  }

  reloadProductItems(): void {
    this.productItemService.index().subscribe(
      (productItems) => {
        this.productItems = productItems;
      },
      (error) => {
        console.error('Error retrieving product items');
        console.error(error);
      }
    );
  }

  displayProductItems(Productitem: Productitem): void {
    this.selectedProductItem = Productitem;
  }

  // displayProductItems(Productitem: Productitem): void {
  //   this.selected = Productitem;
  // }

  // addProductItems(Productitem: Productitem) {
  //   this.ProductItemService.create(Productitem).subscribe(
  //     (newProductItem) => {
  //       console.log('ProductList.addProduct(): product created successfully');
  //       this.reloadProductItems();
  //       this.newProductItem = new Productitem();
  //     },
  //     (err) => {
  //       console.error('ProductList.addProduct(): Error creating Product');
  //       console.error(err);
  //     }
  //   );
  // }

  toBorrow(productitem: Productitem) {
    this.borrowService.create(productitem).subscribe(
      () => {},
      (err) => {
        console.error('ProductList.addProduct(): Error creating Product');
        console.error(err);
      }
    );
  }
}
