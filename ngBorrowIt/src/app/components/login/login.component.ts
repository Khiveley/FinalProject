import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user: User = new User();

  constructor(private auth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  login(user: User) {
    console.log('Logging in as: ');
    console.log(user);
    this.auth.login(user.username, user.password).subscribe(
      (loggedIn) => {
        console.log(loggedIn);
        console.log('Logged in.');
        this.router.navigateByUrl('/todo');
      },
      (fail) => {
        console.error('LoginComponent.login(): login failed');
        console.error(fail);
      }
    );
  }
}
