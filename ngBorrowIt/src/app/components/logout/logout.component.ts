import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css'],
})
export class LogoutComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) {}

  ngOnInit(): void {}

<<<<<<< HEAD

  ngOnInit(): void {
    console.log("Logging out.");
=======
  logout() {
    console.log('Logging out.');
>>>>>>> 9a97053656626ae373ead11110d2b5a4985c80dc
    this.auth.logout();
    this.router.navigateByUrl('/home');
  }
  logout() {
    console.log('Logging out.');
}
}
