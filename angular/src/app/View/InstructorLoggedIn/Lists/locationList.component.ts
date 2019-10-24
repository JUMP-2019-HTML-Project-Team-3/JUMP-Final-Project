import { Component, OnInit } from '@angular/core';
import { Location } from '../../../models/location.model';

@Component({
    selector: 'app-instructor-locations',
    templateUrl: './locationList.component.html'
})

export class LocationListComponent {
  constructor(public location: Location) { }
}