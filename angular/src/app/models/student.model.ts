import { User } from "./user.model";
import { UserType } from "./userType.model";
import { Instructor } from "./instructor.model";
import { Client } from "./client.model";
import { Resource } from "./resource.model";
import { Tool } from "./tool.model";
import { Location } from "./location.model";

export class Student {
    constructor (
        public id?: number,
        public imagePath?: string,
        public firstName?: string,
        public lastName?: string,
        public description?: string,
        public user?: User,
        public userType?: UserType,
        public instructors?: Instructor,
        public clients?: Client,
        public resources?: Resource,
        public tool?: Tool,
        public location?: Location


    ) {}
}