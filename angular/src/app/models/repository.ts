import { Address } from './address.model';
import { Client } from './client.model';
import { Instructor } from './instructor.model';
import { Location } from './location.model';
import { Resource } from './resource.model';
import { Student } from './student.model';
import { Tool } from './tool.model';
import { User } from './user.model';
import { UserType } from './userType.model';
import { HttpClient, HttpResponse, HttpParams, HttpHeaders } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';
/* import { StaticDataSource } from "./static.datasource";
When Angular needs to create a new instance of the repository,
it will inspect the class and see that it needs a StaticDataSourceobject
to invoke the Repository constructor and create a new object. */

const API_ENDPOINT = 'http://localhost:8080/api';
const addressesUrl = API_ENDPOINT + '/addresses';
const clientsUrl = API_ENDPOINT + '/clients';
const instructorsUrl = API_ENDPOINT + '/instructors';
const locationsUrl = API_ENDPOINT + '/locations';
const resourcesUrl = API_ENDPOINT + '/resources';
const studentsUrl = API_ENDPOINT + '/students';
const toolsUrl = API_ENDPOINT + '/tools';
const usersUrl = API_ENDPOINT + '/users';
const userTypesUrl = API_ENDPOINT + '/userTypes';

@Injectable()
export class Repository {

    addressListFetched: Subject<boolean> = new Subject();
    clientListFetched: Subject<boolean> = new Subject();
    instructorListFetched: Subject<boolean> = new Subject();
    locationListFetched: Subject<boolean> = new Subject();
    resourceListFetched: Subject<boolean> = new Subject();
    studentListFetched: Subject<boolean> = new Subject();
    toolListFetched: Subject<boolean> = new Subject();
    userListFetched: Subject<boolean> = new Subject();
    userTypeListFetched: Subject<boolean> = new Subject();

    address: Address;
    addresses: Address[];
    client: Client;
    clients: Client[];
    instructor: Instructor;
    instructors: Instructor[];
    location: Location;
    locations: Location[];
    resource: Resource;
    resources: Resource[];
    student: Student;
    students: Student[];
    tool: Tool;
    tools: Tool[];
    user: User;
    users: User[];
    userType: UserType;
    userTypes: UserType[];

    constructor(private http: HttpClient) {
    this.getAddresses();
    this.getClients();
    this.getInstructors();
    this.getLocations();
    this.getResources();
  }

    //Stuff for Address
    subscribeToAddressFetch(): Subject<boolean> {
        return this.addressListFetched;
      }

    getAddress(id: number) {
        this.http.get(addressesUrl + '/' + id)
          .subscribe(response => this.address = response);
      }

    getAddresses() {
        this.http.get(addressesUrl)
        .subscribe(response => this.address = response);
    }
        
    createAddress(newAddress: Address) {
      this.http.post<Address>(addressesUrl, newAddress).subscribe(response => {
          newAddress.id = response.id;
          this.addresses.push(newAddress);
        });
      }

      /*
       createMovie(mov: Movie) {
        this.http.post<Movie>(moviesUrl, mov, { withCredentials: true }).subscribe(response => {
        mov.movieId = response.movieId;
        this.movies.push(mov);
      });
  }
      */

    //Stuff for Client
    subscribeToClientFetch(): Subject<boolean> {
        return this.clientListFetched;
      }

    getClient(id: number) {
        this.http.get(clientsUrl + '/' + id)
          .subscribe(response => this.client = response);
      }

    getClients() {
        this.http.get(clientsUrl)
        .subscribe(response => this.client = response);
        };

    //Stuff for Instructor
    subscribeToInstructorFetch(): Subject<boolean> {
        return this.instructorListFetched;
      }

    getInstructor(id: number) {
        this.http.get(instructorsUrl + '/' + id)
          .subscribe(response => this.instructor = response);
      }

    //Stuff for Location
    subscribeToLocationFetch(): Subject<boolean> {
        return this.locationListFetched;
      }

    getLocations(id: number) {
        this.http.get(locationsUrl + '/' + id)
          .subscribe(response => this.location = response);
      }

    //Stuff for Resource
    subscribeToResourceFetch(): Subject<boolean> {
        return this.resourceListFetched;
      }

    getResources(id: number) {
        this.http.get(resourcesUrl + '/' + id)
          .subscribe(response => this.resource = response);
      }

    //Stuff for Student
    subscribeToStudentFetch(): Subject<boolean> {
        return this.studentListFetched;
      }
    getStudent(id: number) {
        this.http.get(studentsUrl + '/' + id)
        .subscribe(response => this.student = response);
      }
    getStudents() {
        this.http.get(studentsUrl)
        .subscribe(response => this.students = response);
      }
    createStudent(id: number) {
      this.http.post(studentsUrl, id, { withCredentials: true }).subscribe(response => {
        id = response.student;
        this.students.push(id);
      });
    }

    //Stuff for Tool
    subscribeToToolFetch(): Subject<boolean> {
        return this.toolListFetched;
      }

    //Stuff for User
    subscribeToUserFetch(): Subject<boolean> {
        return this.userListFetched;
      }

    //Stuff for UserType
    subscribeToUserTypeFetch(): Subject<boolean> {
        return this.userTypeListFetched;
      }


}


import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

const API_ENDPOINT = 'http://localhost:8080/api';
const studiosUrl = API_ENDPOINT + '/studios';
const moviesUrl = API_ENDPOINT + '/movies';
const ordersUrl = API_ENDPOINT + '/orders';
const sessionsUrl = API_ENDPOINT + '/session';

@Injectable()
export class Repository {
  private filterObject = new Filter();
  private paginationObject = new Pagination();
  pageChange: Subject<number> = new Subject();
  movieListFetched: Subject<boolean> = new Subject();

  movie: Movie;
  movies: Movie[];
  studios: Studio[] = [];
  categories: string[] = [];
  orders: Order[] = [];

  constructor(private http: HttpClient) {
    this.filter.related = true;
    this.getMovies();
  }

  subscribeToPageChange(): Subject<number> {
    return this.pageChange;
  }

  subscribeToMovieFetch(): Subject<boolean> {
    return this.movieListFetched;
  }

  changePage(page: number) {
    this.pagination.currentPage = page;
    this.pageChange.next(page);
  }

  getMovie(id: number) {
    this.http.get(moviesUrl + '/' + id)
      .subscribe(response => this.movie = response);
  }

  getMovies(related = false) {
    let url = moviesUrl + '?related=' + this.filter.related;
    if (this.filter.category) {
      url += '&category=' + this.filter.category;
    }
    if (this.filter.search) {
      url += '&search=' + this.filter.search;
    }

    url += '&metadata=true';
    this.http.get<any>(url).subscribe(response => {
      this.movies = response;
      this.pagination.currentPage = 1;
      if (!this.filter.category) {
        this.populateCategories();
      }
      this.movieListFetched.next(true);
    });

  }

  private populateCategories() {
    const groups = this.groupBy(this.movies, 'category');
    this.categories = Object.keys(groups);
  }

  private groupBy = function (xs, key) {
    return xs.reduce(function (rv, x) {
      (rv[x[key]] = rv[x[key]] || []).push(x);
      return rv;
    }, {});
  };

  storeSessionData(dataType: string, data: any) {
    return this.http.post(sessionsUrl + '/' + dataType, data, { withCredentials: true })
      .subscribe(response => { });
  }

  getSessionData(dataType: string): any {
    return this.http.get(sessionsUrl + '/' + dataType, { withCredentials: true });
  }

  /** admin screen functions 

  getStudios() {
    this.http.get<Studio[]>(studiosUrl)
      .subscribe(response => this.studios = response);
  }

  createMovie(mov: Movie) {
    this.http.post<Movie>(moviesUrl, mov, { withCredentials: true }).subscribe(response => {
        mov.movieId = response.movieId;
        this.movies.push(mov);
      });
  }

  createMovieAndStudio(mov: Movie, stu: Studio) {
    const data = {
      name: stu.name, city: stu.city, state: stu.state
    };
    this.http.post<number>(studiosUrl, data)
      .subscribe(response => {
        stu.studioId = response;
        mov.studio = stu;
        this.studios.push(stu);
        if (mov != null) {
          this.createMovie(mov);
        }
      });
  }

  replaceMovie(mov: Movie) {
    const data = {
      image: mov.image, name: mov.name, category: mov.category,
      description: mov.description, price: mov.price,
      studio: mov.studio ? mov.studio.studioId : 0
    };
    this.http.put(moviesUrl + '/' + mov.movieId, data ).subscribe(response => this.getMovies());
  }

  replaceStudio(stu: Studio) {
    const data = {
      name: stu.name, city: stu.city, state: stu.state
    };
    this.http.put(studiosUrl + '/' + stu.studioId, data).subscribe(response => this.getMovies());
  }

  updateMovie(id: number, changes: Map<string, any>) {
    const patch = [];
    changes.forEach((value, key) =>
      patch.push({ op: 'replace', path: key, value: value }));
    this.http.patch(moviesUrl + '/' + id, patch)
      .subscribe(response => this.getMovies());
  }

  deleteMovie(id: number) {
    this.http.delete(moviesUrl + '/' + id)
      .subscribe(response => this.getMovies());
  }

  deleteStudio(id: number) {
    this.http.delete(studiosUrl + '/' + id)
      .subscribe(response => {
        this.getMovies();
        this.getStudios();
      });
  }

  getOrders() {
    this.http.get<Order[]>(ordersUrl).subscribe(data => this.orders = data);
  }

  createOrder(order: Order) {
    this.http.post<any>(ordersUrl, {
      name: order.name,
      address: order.address,
      payment: order.payment,
      movies: order.movies
    }, { withCredentials: true }).subscribe(data => {
      order.orderConfirmation = data;
      order.cart.clear();
      order.clear();
    });
  }

  shipOrder(order: Order) {
    this.http.post(ordersUrl + '/' + order.orderId, null, { withCredentials: true }).subscribe(r => this.getOrders());
  }

  get filter(): Filter {
    return this.filterObject;
  }
  get pagination(): Pagination {
    return this.paginationObject;
  }
}
*/