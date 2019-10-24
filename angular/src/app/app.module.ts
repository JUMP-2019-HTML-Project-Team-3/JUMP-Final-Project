// Angular Modules
import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { RouterModule, Routes } from '@angular/router';
import { RoutingConfig } from './app.routing';
// Custom Module Imports
import { InstructorModule } from './View/InstructorLoggedIn/instructor.module';
// Component Imports
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {UserLoginComponent} from './View/userLogin.component';
import { LogoutComponent } from './logout/logout.component';
import { CheckComponent } from './check/check.component';
import { HomePageComponent } from './View/homePage.component';

@NgModule({
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  declarations: [
    AppComponent,
    NavbarComponent,
    UserLoginComponent,
    HomePageComponent,
    LogoutComponent,
    CheckComponent
  ],
  imports: [
    RoutingConfig,
    BrowserModule,
    ReactiveFormsModule,
    InstructorModule,
    HttpClientModule
  ],
  providers: [
    //Repository
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
