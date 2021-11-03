import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { RegisterComponent } from './components/register/register.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { AboutpageComponent } from './components/aboutpage/aboutpage.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { SearchpageComponent } from './components/searchpage/searchpage.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { DatePipe } from '@angular/common';
import { BorrowService } from './services/borrow.service';
import { ProductService } from './services/product.service';
import { UserService } from './services/user.service';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { MustLogInComponent } from './components/must-log-in/must-log-in.component';
import { ConfirmationComponent } from './components/confirmation/confirmation.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent,
    UserpageComponent,
    HomeComponent,
    NotfoundComponent,
    AboutpageComponent,
    NavigationComponent,
    SearchpageComponent,
    LandingPageComponent,
    MustLogInComponent,
    ConfirmationComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [
    AuthService,
    DatePipe,
    BorrowService,
    ProductService,
    UserService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
