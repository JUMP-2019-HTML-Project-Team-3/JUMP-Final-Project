import {Component, Input, OnInit} from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Repository } from '../models/repository';

@Component({
  selector: 'app-check',
  templateUrl: './check.component.html',
  styleUrls: ['./check.component.css']
})
export class CheckComponent implements OnInit {

  constructor(private loginService: AuthenticationService,
              private repo: Repository) { }

  ngOnInit() {
  }

}
