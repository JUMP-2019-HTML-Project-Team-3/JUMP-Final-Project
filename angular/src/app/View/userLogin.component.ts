import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import { HttpClient } from '@angular/common/http';
import { stringify } from 'querystring';
import { Repository } from '../models/repository';
import {User} from '../models/user.model';
import {UserType} from '../models/userType.model';
import {Student} from '../models/student.model';
import {Login} from '../models/login.model';
@Component({
    templateUrl: './userLogin.component.html',
    styleUrls: ['./userLogin.component.css']
})
export class UserLoginComponent implements OnInit {
  signInForm: FormGroup;
  invalidLogin = false;
  signUp: boolean;
  loggedInTry: boolean;

  constructor(private router: Router,
              private loginservice: AuthenticationService,
              private repo: Repository,
              private http: HttpClient) { }

  ngOnInit() {

    this.signInForm = new FormGroup({
      'userData': new FormGroup({
        'username': new FormControl(null, [Validators.required]),
        'password': new FormControl(null, [Validators.required]),
        'email': new FormControl(null, [Validators.required]),
        'uType': new FormControl(null, [Validators.required])
      })
    });

    this.signUp = false;
    this.loggedInTry = false;
  }

  // onSubmit() {
  //   this.repo.user = new User(0,
  //     this.signInForm.get('userData.username').value,
  //     this.signInForm.get('userData.password').value,
  //     'N/A',
  //     new UserType(0, 'temp'));
  //
  //   this.loginservice.authenticate();
  // }

  async onSubmit() {
    this.repo.login = new Login(0,
      this.signInForm.get('userData.username').value,
      this.signInForm.get('userData.password').value,
      'N/A', 0);

    await (this.loginservice.authenticate());

    console.log('DONE');
    if (this.loginservice.isUserLoggedIn()) {
      this.loggedInTry = true;
    }
  }

  signUpSelect() {
    this.signUp = !this.signUp;
  }

  signUpUser() {
    // this.repo.login = new Login(0,
    //   this.signInForm.get('userData.username').value,
    //   this.signInForm.get('userData.password').value,
    //   this.signInForm.get('userData.email').value,
    //   this.signInForm.get('userData.uType').value);
    if (this.signInForm.valid) {
      console.log(this.signInForm.get('userData.uType').value, this.signInForm.get('userData.email').value);
    }
  }
}
