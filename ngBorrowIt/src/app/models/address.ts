import { User } from "./user";
export class Address {
  id: number;
  city: string;
  state: string;
  zip: number;
  Users: User[];

constructor(id: number = 0, city: string = '', state: string = '', zip: number = 0,Users: User[] = []) {
  this.id = id;
  this.city = city;
  this.state = state;
  this.zip = zip;
  this.Users = Users;
}

}
