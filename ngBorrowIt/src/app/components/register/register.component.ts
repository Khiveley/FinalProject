import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  newUser: User = new User();

  constructor(private auth: AuthService, private router: Router) {}

  ngOnInit(): void {}

  register(user: User) {
    console.log('Registering user:');
    console.log(user);
    this.auth.register(user).subscribe(
      (data) => {
        console.log('RegisterComponent.register(): user registered.');
        this.auth.login(this.newUser.username, this.newUser.password).subscribe(
          (next) => {
            console.log(
              'RegisterComponent.register(): user logged in, routing to /user.'
            );
            this.router.navigateByUrl('/user');
          },
          (error) => {
            console.error('RegisterComponent.register(): error logging in.');
          }
        );
      },
      (err) => {
        console.error('RegisterComponent.register(): error registering.');
        console.error(err);
      }
    );
  }
}
