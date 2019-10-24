import { Routes, RouterModule } from '@angular/router';
import {Student} from './models/student.model';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';
import { UserLoginComponent } from './View/userLogin.component';
import { HomePageComponent } from './View/homePage.component';

const routes: Routes = [
  { path: '', redirectTo: 'instructor', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'instructor', component: InstructorHomeComponent},
  { path: 'student', component: Student },
  { path: 'login', component: UserLoginComponent}
];

export const RoutingConfig = RouterModule.forRoot(routes);
