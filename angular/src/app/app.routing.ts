import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './View/userLogin.component';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';
import {Student} from './models/student.model';

const routes: Routes = [
  {
    path: 'student', component: Student
    path: '', component: InstructorHomeComponent
  }];

export const RoutingConfig = RouterModule.forRoot(routes);
