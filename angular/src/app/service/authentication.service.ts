import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {UserType} from '../models/userType.model';
import { HttpClient } from '@angular/common/http';
import { Repository } from '../models/repository';
import { Router } from '@angular/router';
import {SignupUser} from '../models/signupUser';
import {Student} from '../models/student.model';
import {Instructor} from '../models/instructor.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  testLogin: boolean;

  constructor(private http: HttpClient,
              private repo: Repository,
              private router: Router) {
  }

   async authenticate() {
    const aResponse = await this.http.post('http://localhost:8080/cognixia/login', this.repo.login)
      .subscribe((data: User) => {
        if (data.id == null) {
          this.testLogin = false;
        } else {
          this.repo.user = data;
          sessionStorage.setItem('username', JSON.stringify(this.repo.user));
          this.router.navigate(['']);
          this.testLogin = true;
        }
      });

    return this.testLogin;
  }

  isUserLoggedIn() {
    this.repo.user = JSON.parse(sessionStorage.getItem('username'));
    if (this.repo.user === null) {
      return false;
    }

    return !(this.repo.user.id === 0);
  }

  logout() {
    sessionStorage.removeItem('username');
  }

  async signUp(user, pass, email, uType) {
    this.repo.user = new User(0, user, pass, email, new UserType(uType), new Student(), new Instructor());

    const aResponse = await this.http.post('http://localhost:8080/cognixia/adduser', this.repo.user)
      .subscribe((data: User) => {
        if (data.id == null) {

        } else {
          this.repo.user = data;
          sessionStorage.setItem('username', JSON.stringify(this.repo.user));
          this.router.navigate(['']);
        }
      });
  }
}
