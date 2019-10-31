import { Component, OnInit, Input } from '@angular/core';
import {Repository} from '../../models/repository';
import { Student } from '../../models/student.model';
import { Location } from '../../models/location.model';
import { Instructor } from '../../models/instructor.model';
import { Tool } from '../../models/tool.model';
import { Resource} from '../../models/resource.model';


@Component({
    //selector: 'app-instructor-home',
    templateUrl: './instructorHome.component.html'
})  

export class InstructorHomeComponent{ 
    // @Input() location: Location;
    // @Input() student: Student;
    // @Input() instructor: Instructor;
    // @Input() resource: Resource;
    // @Input() tool: Tool;
  
    constructor(private repo: Repository ) { } 

}
