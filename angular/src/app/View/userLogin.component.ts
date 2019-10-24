import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AuthenticationService} from '../service/authentication.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
// import { User } from '../models/user.model';
import {stringify} from 'querystring';
@Component({
    templateUrl: './userLogin.component.html',
    styleUrls: ['./userLogin.component.css']
})
export class UserLoginComponent implements OnInit {
  signInForm: FormGroup;
  invalidLogin = false;

  constructor(private router: Router,
              private loginservice: AuthenticationService,
              private http: HttpClient) {}

  ngOnInit() {

    this.signInForm = new FormGroup({
      'userData': new FormGroup({
        'username': new FormControl(null, [Validators.required]),
        'password': new FormControl(null, [Validators.required])
      })
    });
  }

  onSubmit() {
    // this.user.username = this.signInForm.get('userData.username').value;
    // this.user.password = this.signInForm.get('userData.password').value;
    //
    // const aResponse = this.http.post('http://localhost:8080/login', this.user);
    //
    // if (stringify(aResponse) === 's') {
    //   this.router.navigate(['./check']);
    //   this.invalidLogin = false;
    // } else {
    //   this.invalidLogin = true;
    //   console.log(stringify(aResponse));
    // }
    //
    // console.log('DOne');
  }
}
