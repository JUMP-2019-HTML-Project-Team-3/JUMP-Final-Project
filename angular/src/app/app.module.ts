import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// import { AppRoutingModule } from './app-routing.module';
// import { InstructorModule } from './View/InstructorLoggedIn/instructor.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {UserLoginComponent} from './View/userLogin.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {Student} from './models/student.model';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/instructor', pathMatch: 'full' },
  { path: 'instructor', component: InstructorHomeComponent},
  { path: 'student', component: Student },
  { path: 'login', component: UserLoginComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UserLoginComponent,
    InstructorHomeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
    // InstructorModule
  ],
  providers: [

  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
