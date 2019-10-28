import {Component} from '@angular/core';
import {Repository} from '../../../models/repository';

@Component({
    selector: 'app-instructor-students',
    templateUrl: './studentList.component.html'
})

export class StudentListComponent {

  constructor(private repo: Repository) {
      
  }
}
