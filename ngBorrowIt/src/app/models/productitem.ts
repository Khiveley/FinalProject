import { Product } from "./product";
import { User } from "./user";

export class Productitem {
	id: number;
	quality: string;
  product: Product;
  user: User;
  version: string;
  available: boolean;

  constructor(id: number = 0,
    quality: string = '',
    product: Product,
    user: User,
    version: string = '',
    available: boolean = false
    ) {
      this.id = id;
      this.quality = quality;
      this.product = product;
      this.user = user;
      this.version = version;
      this.available = available;

    }
}
