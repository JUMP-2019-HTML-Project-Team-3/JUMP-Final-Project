import { Address } from "./address.model";
import { Student } from "./student.model";
import { Instructor } from "./instructor.model"

export class Location {
    constructor (
        public id?: number,
        public imagePath?: string,
        public name?: string,
        public phoneNo?: string,
        public address?: Address,
        public students?: Student,
        public instructors?: Instructor
    

    ) {}
}