import { Time } from "@angular/common";
import { Address } from "./address";
import { Borrow } from "./borrow";
import { Product } from "./product";
import { Rating } from "./rating";
export class User {
  id: number;
  username: string;
  password: string;
  firstName: string;
  lastName : string;
  email: string;
  createDate: Date;
  enabled: boolean;
  profileImage: string;
  address: Address;
  borrows: Borrow[];
  ratings: Rating[];
  products: Product[];

constructor(
  id: number = 0,
  username: string = '',
  password: string = '',
  firstName: string = '',
  lastName : string = '',
  email: string = '',
  createDate: Date,
  enabled: boolean = false,
  profileImage: string = '',
  address: Address,
  borrows: Borrow[] = [],
  ratings: Rating[] = [],
  products: Product[] = []) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName  = lastName;
    this.email = email;
    this.createDate = createDate;
    this.enabled = enabled;
    this.profileImage = profileImage;
    this.address = address;
    this.borrows = borrows;
    this.ratings = ratings;
    this.products = products;

  }

}
