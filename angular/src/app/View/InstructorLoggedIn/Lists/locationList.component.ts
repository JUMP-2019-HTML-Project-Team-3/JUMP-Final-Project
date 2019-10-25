import { Component } from '@angular/core';
import {Repository} from '../../../models/repository';

@Component({
    selector: 'app-instructor-locations',
    templateUrl: './locationList.component.html'
})

export class LocationListComponent {
  constructor(private repo: Repository) { }
}
