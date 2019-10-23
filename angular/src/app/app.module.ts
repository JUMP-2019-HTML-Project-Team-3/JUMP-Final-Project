import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {UserLoginComponent} from './View/userLogin.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import { LogoutComponent } from './logout/logout.component';
import { CheckComponent } from './check/check.component';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {User} from './models/user.model';

const appRoutes: Routes = [
  { path: '', redirectTo: '/check', pathMatch: 'full' },
  { path: 'login', component: UserLoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'check', component: CheckComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UserLoginComponent,
    LogoutComponent,
    CheckComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  providers: [
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
