import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './View/userLogin.component';
import { InstructorHomeComponent } from './View/InstructorLoggedIn/instructorHome.component';

const routes: Routes = [
  {
    path: '', component: InstructorHomeComponent }

];

export const RoutingConfig = RouterModule.forRoot(routes);
