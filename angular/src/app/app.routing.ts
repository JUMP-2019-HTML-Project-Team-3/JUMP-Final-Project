import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './View/userLogin.component';
import {Student} from './models/student.model';

const routes: Routes = [
  {
    path: 'student', component: Student
  }
];

export const RoutingConfig = RouterModule.forRoot(routes);
