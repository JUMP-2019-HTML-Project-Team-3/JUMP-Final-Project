import {Component, Input, OnInit} from '@angular/core';
import { Location } from '../../models/location.model';
import { Student } from '../../models/student.model'

@Component({
    selector: 'app-card',
    templateUrl: './card.component.html'
})

export class CardComponent {
  @Input() location: Location;
  @Input() student: Student;

  constructor() {

  }
}
