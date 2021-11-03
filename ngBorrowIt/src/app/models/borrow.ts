<<<<<<< HEAD
import { leadingComment } from '@angular/compiler';
import { NumberValueAccessor } from '@angular/forms';
import { User } from './user';
=======
import { leadingComment } from "@angular/compiler";
import { NumberValueAccessor } from "@angular/forms";
import { Productitem } from "./productitem";
import { User } from "./user";
>>>>>>> 02bed1530a85fd079dd6ea9a6e531450d88670e2

export class Borrow {
  id: number;
  borrowDate: Date;
  returnDate: Date;
  productItem: Productitem;
  borrower: User;
  borrowerRating: number;
  lenderRating: number;
  borrowerRatingComment: string;
  lenderRatingComment: string;
  user: User = new User();

  constructor(
    id: number = 0,
    borrowDate: Date,
    returnDate: Date,
    productItem: Productitem = new Productitem(),
    borrower: User = new User(),
    borrowerRating: number = 0,
    lenderRating: number = 0,
    borrowerRatingComment: string = '',
    lenderRatingComment: string = '',
    user: User = new User()
<<<<<<< HEAD
  ) {
    this.id = id;
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
=======
    ) {
      this.id = id
      this.borrowDate = borrowDate;
      this.returnDate = returnDate;
      this.productItem = productItem;
      this.borrower = borrower;
      this.borrowerRating = borrowerRating;
      this.lenderRating = lenderRating;
      this.borrowerRatingComment = borrowerRatingComment;
      this.lenderRatingComment = lenderRatingComment;
      this.user = user;
    }
>>>>>>> 02bed1530a85fd079dd6ea9a6e531450d88670e2
}
