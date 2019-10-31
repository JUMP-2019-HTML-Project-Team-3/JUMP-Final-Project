import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatFormField } from '@angular/material';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  public name = '';
  public phone = '';

  constructor(private dialog: MatDialog, private router: Router) { }

  ngOnInit() {
  }

  addClient() {

  }
}
