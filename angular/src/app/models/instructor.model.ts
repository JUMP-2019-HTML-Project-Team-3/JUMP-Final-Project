import { User } from "./user.model";
import { UserType } from "./userType.model";
import { Student } from "./student.model";
import { Resource } from "./resource.model";
import { Tool } from "./tool.model";

export class Instructor {
    constructor (
        private id?: number,
        private imagePath?: string,
        private firstName?: string,
        private lastName?: string,
        private description?: string,
        private user?: User,
        private userType?: UserType,
        private students?: Student,
        private resources?: Resource,
        private tools?: Tool

    ) {}

}