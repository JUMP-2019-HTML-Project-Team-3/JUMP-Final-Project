import { UserType } from './userType.model';
import {Student} from './student.model';
import {Instructor} from './instructor.model';

export class SignupUser {
  constructor(
    public id?: number,
    public username?: string,
    public password?: string,
    public email?: string,
    public userType?: UserType
  ) {}
}
