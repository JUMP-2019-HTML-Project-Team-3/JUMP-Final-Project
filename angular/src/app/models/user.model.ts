import { UserType } from "./userType.model";

export class User {
    constructor (
        private id?: number,
        private username?: string,
        private password?: string,
        private email?: string,
        private userType?: UserType,
    ) {}
}