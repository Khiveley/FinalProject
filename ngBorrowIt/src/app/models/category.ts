import { Product } from "./product";

export class Category {
  id: number;
  category: string;
  products: Product[];

  constructor(id:number=0, category:string='', products: Product[] = []) {
    this.id = id;
    this.category = category;
    this.products = products;
  }
}
