import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
@Component({
    templateUrl: './userLogin.component.html'
})
export class UserLoginComponent implements OnInit
{
  signInForm: FormGroup;

  constructor() {}

  ngOnInit() {
    this.signInForm = new FormGroup({
      'userData': new FormGroup({
        'username': new FormControl(null, [Validators.required])
      })
    });


  }
}
