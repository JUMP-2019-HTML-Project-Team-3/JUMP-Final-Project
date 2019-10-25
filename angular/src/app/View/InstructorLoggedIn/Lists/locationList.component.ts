import { Component } from '@angular/core';
import {Repository} from '../../../models/repository';

@Component({
    selector: 'app-instructor-locations',
    templateUrl: './locationList.component.html'
})

export class LocationListComponent {
  locations;

  constructor(private repo: Repository) {
    this.locations = this.repo.locations;
    // console.log(this.repo.locations.length);
  }
}
