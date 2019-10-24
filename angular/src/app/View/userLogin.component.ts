import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { stringify } from 'querystring';
import { Repository } from '../models/repository';
import {User} from '../models/user.model';
import {UserType} from '../models/userType.model';
@Component({
    templateUrl: './userLogin.component.html',
    styleUrls: ['./userLogin.component.css']
})
export class UserLoginComponent implements OnInit {
  signInForm: FormGroup;
  invalidLogin = false;

  constructor(private router: Router,
              private loginservice: AuthenticationService,
              private repo: Repository,
              private http: HttpClient) { }

  ngOnInit() {

    this.signInForm = new FormGroup({
      'userData': new FormGroup({
        'username': new FormControl(null, [Validators.required]),
        'password': new FormControl(null, [Validators.required])
      })
    });
  }

  onSubmit() {
    this.repo.user = new User(0,
      this.signInForm.get('userData.username').value,
      this.signInForm.get('userData.password').value,
      'N/A',
      new UserType(0, 'temp'));

    this.loginservice.authenticate();

    // const aResponse = this.http.post('http://localhost:8080/login', this.repo.user)
    //   .subscribe((data: User) => {
    //     if (data.id == null) {
    //       console.log('Error');
    //     } else {
    //       console.log(data.username);
    //     }
    //   });

    console.log('DOne');
  }
}
