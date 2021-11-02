import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { Productitem } from 'src/app/models/productitem';
import { User } from 'src/app/models/user';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css'],
})
export class UserpageComponent implements OnInit {
  products: Product[] = [];

  selected: Product | null = null;
  newProduct: Product = new Product();
  editProduct: Product | null = null;
  editProductItem: Productitem | null = null;
  editUser: User | null = null;
  newProductItem: Productitem = new Productitem();

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
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

  addProductItem(productItem: Productitem) {}
  //   this.productService.create(productItem).subscribe(
  //     (newProduct) => {
  //       console.log('ProductList.addProduct(): product created successfully');
  //       this.reloadProducts();
  //       this.newProduct = new Product();
  //     },
  //     (err) => {
  //       console.error('ProductItemList.addProductItem(): Error creating Product item');
  //       console.error(err);
  //     }
  //   );
  // }

  // displayProductItem(productItem: Productitem): void {
  //   this.selected = productItem;
  // }
  // reloadProductsItems(): void {
  //   this.productService.index().subscribe(
  //     (productitems) => {
  //       this.products = productitems;
  //     },
  //     (error) => {
  //       console.error('Error retrieving products');
  //       console.error(error);
  //     }
  //   );
  // }

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

  setEditProductItem(): void {
    this.editProduct = Object.assign({}, this.selected);
  }

  updateProductItem(product: Product, showProduct = true): void {
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
          'ProductItemComponent.updateProduct(): error updating product'
        );
        console.error(failure);
      }
    );
  }

  setEditUser(): void {
    // this.editUser = Object.assign({}, this.selected);
  }

  updateUser(product: Product, showProduct = true): void {
    this.productService.update(product).subscribe(
      (updated) => {
        this.reloadProducts();
        this.editUser = null;
        // if (show) {
        //   this.selected = updated;
        // }
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
}
