import {Component, Input, OnInit} from '@angular/core';
import { Location } from '../../models/location.model';

@Component({
    selector: 'app-card',
    templateUrl: './card.component.html'
})

export class CardComponent {
  @Input() location: Location;

  constructor() {

  }
}
