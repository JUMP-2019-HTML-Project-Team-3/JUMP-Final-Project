import { User } from "./user.model";
import { UserType } from "./userType.model";
import { Student } from "./student.model";
import { Resource } from "./resource.model";
import { Tool } from "./tool.model";

export class Instructor {
    constructor (
        public id?: number,
        public imagePath?: string,
        public firstName?: string,
        public lastName?: string,
        public description?: string,
        public user?: User,
        public userType?: UserType,
        public students?: Student,
        public resources?: Resource,
        public tools?: Tool

    ) {}

}