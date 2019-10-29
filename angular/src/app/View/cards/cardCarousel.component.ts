import { Component, Input, OnInit } from '@angular/core';
import { Location } from '../../models/location.model';
import { Student } from '../../models/student.model'

@Component({
    selector: 'app-cardcarousel',
    templateUrl: './cardCarousel.component.html'
})

export class CardCarouselComponent {
  @Input() location: Location;
  @Input() student: Student;

  constructor() {}

}
