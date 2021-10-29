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
    SearchpageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
