import { Component } from '@angular/core';
import { Repository } from './models/repository';

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
