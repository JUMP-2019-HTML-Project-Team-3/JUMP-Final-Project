import { User } from "./user.model";
import { UserType } from "./userType.model";
import { Instructor } from "./instructor.model";
import { Client } from "./client.model";
import { Resource } from "./resource.model";
import { Tool } from "./tool.model";
import { Location } from "./location.model";

export class Student {
    constructor (
        private id?: number,
        private imagePath?: string,
        private firstName?: string,
        private lastName?: string,
        private description?: string,
        private user?: User,
        private userType?: UserType,
        private instructors?: Instructor,
        private clients?: Client,
        private resources?: Resource,
        private tool?: Tool,
        private location?: Location


    ) {}
}