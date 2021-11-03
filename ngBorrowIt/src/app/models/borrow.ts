import { leadingComment } from '@angular/compiler';
import { NumberValueAccessor } from '@angular/forms';
import { Productitem } from './productitem';
import { User } from './user';

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
  ) {
    this.id = id;
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
}
