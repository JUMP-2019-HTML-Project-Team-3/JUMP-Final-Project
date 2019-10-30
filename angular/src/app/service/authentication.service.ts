import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {UserType} from '../models/userType.model';
import { HttpClient } from '@angular/common/http';
import { Repository } from '../models/repository';
import { Router } from '@angular/router';
import {SignupUser} from '../models/signupUser';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  signupuser: SignupUser;
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
    this.signupuser = new SignupUser(user, pass, email, uType);

    const aResponse = await this.http.post('http://localhost:8080/cognixia/addusers', this.repo.login)
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
  }
}
