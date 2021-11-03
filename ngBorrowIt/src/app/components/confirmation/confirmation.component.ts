import { Component, OnInit } from '@angular/core';
import { Productitem } from 'src/app/models/productitem';
import { User } from 'src/app/models/user';
import { Product } from 'src/app/models/product';
import { ActivatedRoute } from '@angular/router';
import { BorrowService } from 'src/app/services/borrow.service';
import { Borrow } from 'src/app/models/borrow';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css'],
})
export class ConfirmationComponent implements OnInit {
  title = 'BorrowIt';

  borrow: Borrow | null = null;
  user: User = new User();
  product: Product = new Product();

  borrowId: number | null = 0;

  constructor(private currentRoute: ActivatedRoute, private borrowService: BorrowService) {}

  ngOnInit(): void {
    let param = this.currentRoute.snapshot.paramMap.get('id');
    if (param) {
      this.borrowId = Number.parseInt(param);
      if (this.borrowId) {
        this.borrowService.show(this.borrowId).subscribe(
          borrow => {
            this.borrow = borrow
          },
          fail => {
            console.log('Error')
          }
        );
      }
    }
  }
}
