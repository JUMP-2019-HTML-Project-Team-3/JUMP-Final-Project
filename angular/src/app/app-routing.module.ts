import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './View/userLogin.component';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';
import {Student} from './models/student.model';
import {NgModule} from '@angular/core';

const routes: Routes = [
  { path: 'student', component: Student },
  { path: 'login', component: UserLoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
