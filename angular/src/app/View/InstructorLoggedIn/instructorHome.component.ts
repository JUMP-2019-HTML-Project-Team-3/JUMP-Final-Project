import { Component, OnInit } from '@angular/core';
import {Repository} from '../../models/repository';
// import { Student } from '../../models/student.model';
// import { Location } from '../../models/location.model';


@Component({
    //selector: 'app-instructor-home',
    templateUrl: './instructorHome.component.html'
})  

export class InstructorHomeComponent{ 
    constructor(private repo: Repository ) { } 

    //students: Student[] = [];
     
    // ngOnInit() {
    //     console.log('init called');
    //     this.repo.subscribeToStudentFetch().subscribe(resp => {
    //         console.log("this.repo.students");
    //         console.log(this.repo.students);
    //         if (this.repo.students != null && this.repo.students.length > 0) {
    //             this.students = this.repo.students;
    //             console.log("this.students");
    //             console.log(this.students);
    //           }});
    //   }

    //this.repo.students 
    //locations: Location[] = [];


}
