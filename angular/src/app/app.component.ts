import { Component } from '@angular/core';
import { Repository } from './models/repository';
import { Address}  from './models/address.model';
import { Client}  from './models/client.model';
import { Instructor}  from './models/instructor.model';
import { Location}  from './models/location.model';
import { Resource}  from './models/resource.model';
import { Student}  from './models/student.model';
import { Tool}  from './models/tool.model';
import { User}  from './models/user.model';
import { UserType}  from './models/userType.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Collabera Web Development';
  constructor(private repo: Repository) {}//.ts file is currently empty

  get address(): Address {
    return this.repo.address; }

  get client(): Client {
    return this.repo.client; }

  get instructor(): Instructor {
    return this.repo.instructor; }

  get location(): Location {
    return this.repo.location; }

  get resource(): Resource {
   return this.repo.resource; }

  get student(): Student {
    return this.repo.student; }

  get tool(): Tool {
   return this.repo.tool; }

  get user(): User {
    return this.repo.user; }

  get usertype(): UserType {
    return this.repo.userType; }
// Have yet to do create, replace, update, or delete
}
