import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { Productitem } from 'src/app/models/productitem';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { BorrowService } from 'src/app/services/borrow.service';
import { ProductItemService } from 'src/app/services/product-item.service';
import { ProductService } from 'src/app/services/product.service';
import { Category } from 'src/app/models/category';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css'],
})
export class UserpageComponent implements OnInit {
  products: Product[] = [];
  user: User[] = [];

  selected: Product | null = null;
  selectedProductItem: Productitem | null = null;
  selectedUser: User | null = null;
  newProduct: Product = new Product();
  editProduct: Product | null = null;
  editProductItem: Product | undefined;
  editUser: User | undefined;
  productItems: Productitem[] | null = [];
  newProductItem: Productitem = new Productitem();
  categories: Category[] =[];


  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
    private borrowService: BorrowService,
    private productItemService: ProductItemService,
    private userService: UserService,
    private authService: AuthService
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
    this.reloadCategories();

    this.authService.getLoginUser().subscribe(
      (user) => {
        this.selectedUser = user;
      },
      (err) => {
        console.error(
          'LoggedInUser(): Error showing user information at login'
        );
        console.error(err);
      }
    );
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
    console.log(product);
    this.productService.create(product).subscribe(
      (newProduct) => {
        console.log('ProductList.addProduct(): product created successfully');
        this.reloadProducts();
        this.newProduct = new Product();
        this.newProduct.category=this.categories[0];
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

  addProductItem(productitem: Productitem) {
    if (this.selected){
    productitem.product= this.selected;
    console.log(productitem);
    this.productItemService.create(productitem).subscribe(
      (newProductitem) => {
        console.log(
          'ProductItemList.addProductItem(): product item created successfully'
        );
        this.reloadProductItems();
        this.newProductItem = new Productitem();
        this.selected = null;
      },
      (err) => {
        console.error('ProductList.addProduct(): Error creating Product');
        console.error(err);
      }
    );
    }
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
  reloadCategories(): void {
    this.productService.getCategories().subscribe(
      (categories) => {
        this.categories = categories;
        this.newProduct.category = categories[0];
      },
      (error) => {
        console.error('Error retrieving categories');
        console.error(error);
      }
    );
  }

  toBorrow(productitem: Productitem) {
    this.borrowService.create(productitem).subscribe(
      () => {},
      (err) => {
        console.error('ProductList.addProduct(): Error creating Product');
        console.error(err);
      }
    );
  }

  setEditProductItem(): void {
    this.editProductItem = Object.assign({}, this.selected);
  }

  displayProductItems(Productitem: Productitem): void {
    this.selectedProductItem = Productitem;
  }
  displayUser(user: User): void {
    this.selectedUser = user;
  }

  setEditUser(): void {
    this.editUser = Object.assign({}, this.selectedUser);
  }
  updateUser() {}
}
