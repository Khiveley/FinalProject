import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutpageComponent } from './components/aboutpage/aboutpage.component';
import { ConfirmationComponent } from './components/confirmation/confirmation.component';
import { HomeComponent } from './components/home/home.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { MustLogInComponent } from './components/must-log-in/must-log-in.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchpageComponent } from './components/searchpage/searchpage.component';
import { UserpageComponent } from './components/userpage/userpage.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'landingPage' },
  { path: 'landingPage', component: LandingPageComponent},
  { path: 'mustLogIn', component: MustLogInComponent},
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutpageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'user', component: UserpageComponent },
  { path: 'search', component: SearchpageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'confirmation', component: ConfirmationComponent},
  { path: '**', component: NotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})],
  exports: [RouterModule]

})
export class AppRoutingModule {}
