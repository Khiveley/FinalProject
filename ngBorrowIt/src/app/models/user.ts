import { state } from '@angular/animations';
import { Address } from './address';

export class User {
  id: number;
  email: string;
  username: string;
  password: string;
  enabled: boolean;
  role: string;
  address: Address;

  constructor(
    id: number = 0,
    email: string = '',
    username: string = '',
    password: string = '',
    enabled: boolean = true,
    role: string = '',
    address: Address = new Address()
  ) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.address = address;
  }
}
