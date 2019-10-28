import { Component, OnInit } from '@angular/core';
import {Repository} from '../../models/repository';
import { Student } from '../../models/student.model';
import { Location } from '../../models/location.model';


@Component({
    selector: 'app-instructor-home',
    templateUrl: './instructorHome.component.html'
})

export class InstructorHomeComponent {
    constructor(private repo: Repository) { }
    
    students: Student[] = [];        
    locations: Location[] = [];
}
