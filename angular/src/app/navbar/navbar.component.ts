import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import {Repository} from '../models/repository';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(
    private loginservice: AuthenticationService,
    private repo: Repository
  ) {}

  ngOnInit() {
  }

}
