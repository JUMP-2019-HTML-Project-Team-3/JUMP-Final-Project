import { Routes, RouterModule } from '@angular/router';
import {StudentHomeComponent} from './View/StudentLoggedIn/studentHome.component';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';
import { UserLoginComponent } from './View/userLogin.component';
import { HomePageComponent } from './View/homePage.component';
import {CheckComponent} from './check/check.component';
import {LogoutComponent} from './logout/logout.component';
import {AddClientComponent} from './addComponents/add-client/add-client.component';
import {AddInstructorComponent} from './addComponents/add-instructor/add-instructor.component';
import {AddLocationComponent} from './addComponents/add-location/add-location.component';
import {AddStudentComponent} from './addComponents/add-student/add-student.component';
import {AddToolComponent} from './addComponents/add-tool/add-tool.component';

const routes: Routes = [
  { path: '', redirectTo: 'instructor', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'instructor', component: InstructorHomeComponent},
  { path: 'student', component: StudentHomeComponent },
  { path: 'login', component: UserLoginComponent},
  { path: 'check', component: CheckComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'addclient', component: AddClientComponent },
  { path: 'addinstructor', component: AddInstructorComponent },
  { path: 'addlocation', component: AddLocationComponent },
  { path: 'addstudent', component: AddStudentComponent },
  { path: 'addtool', component: AddToolComponent },
];

export const RoutingConfig = RouterModule.forRoot(routes);
