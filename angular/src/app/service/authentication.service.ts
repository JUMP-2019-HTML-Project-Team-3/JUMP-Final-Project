import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {UserType} from '../models/userType.model';
import {HttpClient} from '@angular/common/http';
import {Repository} from '../models/repository';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient,
              private repo: Repository) {
  }

  authenticate() {
    // if (username === 'test' && password === 'test') {
    //   sessionStorage.setItem('username', username);
    //   return true;
    // } else {
    //   return false;
    // }

    const aResponse = this.http.post('http://localhost:8080/login', this.repo.user)
      .subscribe((data: User) => {
        if (data.id == null) {
          return false;
        } else {
          this.repo.user = data;
          sessionStorage.setItem('username', JSON.stringify(this.repo.user));
          return true;
        }
      });
  }

  isUserLoggedIn() {
    this.repo.user = JSON.parse(sessionStorage.getItem('username'));
    // const user = JSON.parse(sessionStorage.getItem('username'));
    if (this.repo.user === null) {
      return false;
    }

    console.log(this.repo.user);
    return !(this.repo.user.id === 0);
  }

  logout() {
    sessionStorage.removeItem('username');
  }
}
