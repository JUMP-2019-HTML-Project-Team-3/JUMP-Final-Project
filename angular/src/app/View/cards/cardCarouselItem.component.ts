import { Component, Input, OnInit } from '@angular/core';
import {CardComponent} from './card.component';
import { Location } from '../../models/location.model';
import { Student } from '../../models/student.model';
import { Tool } from '../../models/tool.model';
import { Resource } from '../../models/resource.model';
import { Instructor } from '../../models/instructor.model';
import { Repository } from '../../models/repository';

@Component({
    selector: 'app-cardcarouselitem',
   templateUrl: './cardCarouselItem.component.html'
})

export class CardCarouselItemComponent {
  @Input() location: Location;
  @Input() student: Student;
  @Input() instructor: Instructor;
  @Input() resource: Resource;
  @Input() tool: Tool;


  constructor(private repo: Repository ) {}

}
