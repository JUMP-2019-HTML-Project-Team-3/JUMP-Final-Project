import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {UserType} from '../models/userType.model';
import { HttpClient } from '@angular/common/http';
import { Repository } from '../models/repository';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient,
              private repo: Repository,
              private router: Router) {
  }

  authenticate() {
    const aResponse = this.http.post('http://localhost:8080/cognixia/login', this.repo.login)
      .subscribe((data: User) => {
        if (data.id == null) {
          return false;
        } else {
          this.repo.user = data;
          sessionStorage.setItem('username', JSON.stringify(this.repo.user));
          this.router.navigate(['']);
          return true;
        }
      });
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
}
