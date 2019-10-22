import { Component } from '@angular/core';
import { Repository } from './models/repository';
import { address}  from './models/address.model';
import { client}  from './models/client.model';
import { instructor}  from './models/instructor.model';
import { location}  from './models/location.model';
import { resource}  from './models/resource.model';
import { student}  from './models/student.model';
import { tool}  from './models/tool.model';
import { user}  from './models/user.model';
import { userType}  from './models/userType.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Collabera Web Development';
  constructor(private repo: repository) {}//.ts file is currently empty

  get address(): Address {
    this.repo.address; }

  get client(): Client {
    this.repo.address; }

  get instructor(): Instructor {
    this.repo.address; }

  get location(): Location {
    this.repo.address; }

  get resource(): Resource {
    this.repo.address; }

  get student(): Student {
    this.repo.address; }

  get tool(): Tool {
    this.repo.address; }

  get user(): User {
    this.repo.address; }

  get usertype(): UserType {
    this.repo.address; }
// Have yet to do create, replace, update, or delete
}
