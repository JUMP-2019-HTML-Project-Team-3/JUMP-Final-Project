import { Address } from "./address.model";
import { Student } from "./student.model";
import { Instructor } from "./instructor.model"

export class Location {
    constructor (
        private id?: number,
        private imagePath?: string,
        private name?: string,
        private phoneNo?: string,
        private address?: Address,
        private students?: Student,
        private instructors?: Instructor
    

    ) {}
}