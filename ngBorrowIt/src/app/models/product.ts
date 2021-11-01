import { Category } from "./category";
import { Productitem } from "./productitem";
import { Rating } from "./rating";

export class Product {
  id: number;
	productItems: Productitem[];
  title: string;
  description: string;
  imageUrl: string;
  category: Category;
  ratings: Rating[];
  enabled: boolean;

  constructor(
    id: number = 0,
    productItems: Productitem[] = [],
    title: string = '',
    description: string = '',
    imageUrl: string = '',
    category: Category,
    ratings: Rating[] = [],
    enabled: boolean = false) {
      this.id = id;
      this.productItems = productItems;
      this.title = title;
      this.description = description;
      this.imageUrl = imageUrl;
      this.category = category;
      this.ratings = ratings;
      this.enabled = enabled;
    }



}
