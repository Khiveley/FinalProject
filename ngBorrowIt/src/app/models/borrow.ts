import { leadingComment } from "@angular/compiler";
import { NumberValueAccessor } from "@angular/forms";
import { User } from "./user";

export class Borrow {
  id: number;
  borrowDate: Date;
  returnDate: Date;
  productId: number;
  borrowerId: number;
  borrowerRating: number;
  lenderRating: number;
  borrowerRatingComment: string;
  lenderRatingComment: string;
  user: User = new User();

  constructor(
    id: number = 0,
    borrowDate: Date,
    returnDate: Date,
    productId: number = 0,
    borrowerId: number = 0,
    borrowerRating: number = 0,
    lenderRating: number = 0,
    borrowerRatingComment: string = '',
    lenderRatingComment: string = '',
    user: User = new User()
    ) {
      this.id = id
      this.borrowDate = borrowDate;
      this.returnDate = returnDate;
      this.productId = productId;
      this.borrowerId = borrowerId;
      this.borrowerRating = borrowerRating;
      this.lenderRating = lenderRating;
      this.borrowerRatingComment = borrowerRatingComment;
      this.lenderRatingComment = lenderRatingComment;
      this.user = user;
    }
}
