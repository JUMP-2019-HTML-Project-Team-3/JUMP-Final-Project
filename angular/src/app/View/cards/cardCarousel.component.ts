import { Component, Input, OnInit } from '@angular/core';
import {CardComponent} from './card.component';
import { Location } from '../../models/location.model';
import { Student } from '../../models/student.model'

@Component({
    selector: 'app-cardcarousel',
   // template: '<app-card [cardMessage]="parentMessage"></app-card>',
   //template: 'Message: {{message}} <app-card (messageEvent)="recieveMessage($event)"></app-card>"',
   //template: '{{cardcomponent.location}}',
   templateUrl: './cardCarousel.component.html'
})

export class CardCarouselComponent {
  //parentMessage[] = @Input() location: Location, @Input() student: Student;

  //  @Input() location: Location;
  //  @Input() student: Student;


  constructor() {}

}
