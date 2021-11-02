import { Product } from "./product";
import { User } from "./user";

export class Productitem {
	id: number;
	quality: string;
  product: Product = new Product();
  user: User | undefined;
  version: string;
  available: boolean;

  constructor(id: number = 0,
    quality: string = '',
    product: Product = new Product(),
    version: string = '',
    available: boolean = false,
    user?: User
    ) {
      this.id = id;
      this.quality = quality;
      this.user = user;
      this.version = version;
      this.available = available;
      this.product = product;

    }
}
