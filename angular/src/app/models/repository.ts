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
    this.getStudents();
    this.getTools();
    this.getUsers();
    this.getUserTypes();
  }

    //Stuff for Address
    subscribeToAddressFetch(): Subject<boolean> {
        return this.addressListFetched;
      }

    //Get one Address
    getAddress(id: number) {
        this.http.get(addressesUrl + '/' + id)
          .subscribe(response => this.address = response);
      }

    //Get All Addresses
    getAddresses() {
        this.http.get(addressesUrl)
        .subscribe(response => this.address = response);
    }
      
    //Create New Address
    createAddress(newAddress: Address) {
      this.http.post<Address>(addressesUrl, newAddress).subscribe(response => {
          newAddress.id = response.id;
          this.addresses.push(newAddress);
        });
      }

    //Update Address
    replaceAddress(address1: Address) {
      const data = {
      streetNumber: address1.streetNumber, streetName: address1.streetName, suiteNo: address1.suiteNo,
      township: address1.township, zip: address1.zip, country: address1.country
    };
    this.http.put(addressesUrl + '/' + address1.id, data ).subscribe(response => this.getAddresses());
  }

    //Delete Address
    deleteAddress(id: number) {
      this.http.delete(addressesUrl + '/' + id)
    .subscribe(response => this.getAddresses());
  }

    //Stuff for Client
    subscribeToClientFetch(): Subject<boolean> {
        return this.clientListFetched;
      }
    
    //Get One Client
    getClient(id: number) {
        this.http.get(clientsUrl + '/' + id)
          .subscribe(response => this.client = response);
      }
    
    //Get All Clients
    getClients() {
        this.http.get(clientsUrl)
        .subscribe(response => this.client = response);
        };

    //Create New Client
    createClient(newClient: Client) {
      this.http.post<Client>(clientsUrl, newClient).subscribe(response => {
          newClient.id = response.id;
          this.clients.push(newClient);
        });
      }

    //Update Client
    replaceClient(client1: Client) {
      const data = {
      imagePath: client1.imagePath, name: client1.name, phone: client1.phone,
      description: client1.description, address: client1.address
    };
    this.http.put(clientsUrl + '/' + client1.id, data ).subscribe(response => this.getClients());
  }

    //Delete Client
    deleteClient(id: number) {
      this.http.delete(clientsUrl + '/' + id)
    .subscribe(response => this.getClients());
  }
  

    //Stuff for Instructor
    subscribeToInstructorFetch(): Subject<boolean> {
        return this.instructorListFetched;
      }


    //Get One Instructor
    getInstructor(id: number) {
        this.http.get(instructorsUrl + '/' + id)
          .subscribe(response => this.instructor = response);
      }

    
    //Get All Instructors
    getInstructors() {
        this.http.get(instructorsUrl)
        .subscribe(response => this.instructor = response);
        };

    //Create New Instructor
    createInstructors(newInstructor: Instructor) {
      this.http.post<Instructor>(instructorsUrl, newInstructor).subscribe(response => {
          newInstructor.id = response.id;
          this.clients.push(newInstructor);
        });
      }

    //Update Instructor
    replaceInstructor(instructor1: Instructor) {
      const data = {
      imagePath: instructor1.imagePath, firstName: instructor1.firstName, lastName: instructor1.lastName,
      description: instructor1.description, user: instructor1.user, userType: instructor1.userType,
      students: instructor1.students, resources: instructor1.resources, tools: instructor1.tools
    };
    this.http.put(instructorsUrl + '/' + instructor1.id, data ).subscribe(response => this.getInstructors());
  }

    //Delete Instructor
    deleteInstructor(id: number) {
      this.http.delete(instructorsUrl + '/' + id)
    .subscribe(response => this.getInstructors());
  }

    //Stuff for Location
    subscribeToLocationFetch(): Subject<boolean> {
        return this.locationListFetched;
      }

    //Get One Location
    getLocation(id: number) {
        this.http.get(locationsUrl + '/' + id)
          .subscribe(response => this.location = response);
      }

    //Get All Locations
    getLocations() {
        this.http.get(locationsUrl)
        .subscribe(response => this.location = response);
        };

    //Create New Location
    createLocation(newLocation: Location) {
      this.http.post<Location>(locationsUrl, newLocation).subscribe(response => {
          newLocation.id = response.id;
          this.locations.push(newLocation);
        });
      }
      
    //Update Location
    replaceLocation(location1: Location) {
      const data = {
      imagePath: location1.imagePath, name: location1.name, phoneNo: location1.phoneNo,
      address: location1.address, students: location1.students, instructors: location1.instructors
        };
    this.http.put(locationsUrl + '/' + location1.id, data ).subscribe(response => this.getLocations());
  }

    //Delete Location
    deleteLocation(id: number) {
      this.http.delete(locationsUrl + '/' + id)
    .subscribe(response => this.getLocations());
  }

    //Stuff for Resource
    subscribeToResourceFetch(): Subject<boolean> {
        return this.resourceListFetched;
      }
    
    //Get One Resource
    getResource(id: number) {
        this.http.get(resourcesUrl + '/' + id)
          .subscribe(response => this.resource = response);
      }

    //Get All Resource
    getResources() {
        this.http.get(resourcesUrl)
        .subscribe(response => this.resource = response);
        };

    //Create New Resource
    createResource(newResource: Resource) {
      this.http.post<Resource>(resourcesUrl, newResource).subscribe(response => {
          newResource.id = response.id;
          this.resources.push(newResource);
        });
      }

    //Update Resource
    replaceResource(resource1: Resource) {
      const data = {
      name: resource1.name, link: resource1.link, description: resource1.description
        };
    this.http.put(resourcesUrl + '/' + resource1.id, data ).subscribe(response => this.getResources());
  }

    //Delete Resource
    deleteResource(id: number) {
      this.http.delete(resourcesUrl + '/' + id)
    .subscribe(response => this.getResources());
  }




    // Stuff for Student
    subscribeToStudentFetch(): Subject<boolean> {
        return this.studentListFetched;
      }
    // Get Student
    getStudent(id: number) {
        this.http.get(studentsUrl + '/' + id)
        .subscribe(response => this.student = response);
      }
    // Get all Students
    getStudents() {
        this.http.get(studentsUrl)
        .subscribe(response => this.student = response);
      }
    // Create Student
    createStudent(newStudent: Student) {
      this.http.post<Student>(studentsUrl, newStudent).subscribe(response => {
        newStudent.id = response.id;
        this.students.push(newStudent);});
      }
    // Update Student
    replaceStudent(studentUpd: Student) {
      const data = {
      imagePath: studentUpd.imagePath, firstName: studentUpd.firstName,
      lastName: studentUpd.lastName, description: studentUpd.description,
      user: studentUpd.user, userType: studentUpd.userType, instructors: studentUpd.instructors,
      clients: studentUpd.clients, resources: studentUpd.resources,
      tool: studentUpd.tool, location: studentUpd.location
        };
    this.http.put(studentsUrl + '/' + studentUpd.id, data ).subscribe(response => this.getStudents());
    }
    // Delete Student
    deleteStudent(id: number) {
        this.http.delete(studentsUrl + '/' + id)
        .subscribe(response => this.getStudents());
    }




    // Stuff for Tool
    subscribeToToolFetch(): Subject<boolean> {
        return this.toolListFetched;
      }
    // Get Tool
    getTool(id: number) {
      this.http.get(toolsUrl + '/' + id)
      .subscribe(response => this.tool = response);
    }
    // Get all Tools
    getTools() {
      this.http.get(toolsUrl)
      .subscribe(response => this.tool = response);
    }
    // Create Tool
    createTool(newTool: Tool) {
    this.http.post<Tool>(toolsUrl, newTool).subscribe(response => {
      newTool.id = response.id;
      this.tools.push(newTool);});
    }
  // Update Tool
    replaceTool(toolUpd: Tool) {
    const data = {
    name: toolUpd.name, linkDownLoad: toolUpd.linkDownLoad,
    linkDocumentation: toolUpd.linkDocumentation
      };
  this.http.put(toolsUrl + '/' + toolUpd.id, data ).subscribe(response => this.getTools());
    }
  // Delete Tool
    deleteTool(id: number) {
      this.http.delete(toolsUrl + '/' + id)
      .subscribe(response => this.getTools());
    }




    //Stuff for User
    subscribeToUserFetch(): Subject<boolean> {
        return this.userListFetched;
      }
  // Get User
  getUser(id: number) {
    this.http.get(usersUrl + '/' + id)
    .subscribe(response => this.user = response);
  }
  // Get all Users
  getUsers() {
    this.http.get(usersUrl)
    .subscribe(response => this.user = response);
  }
  // Create User
  createUser(newUser: User) {
  this.http.post<User>(usersUrl, newUser).subscribe(response => {
    newUser.id = response.id;
    this.users.push(newUser);});
  }
// Update User
  replaceUser(userUpd: User) {
  const data = {
  username: userUpd.username, password: userUpd.password, email: userUpd.email, userType: userUpd.userType
    };
this.http.put(usersUrl + '/' + userUpd.id, data ).subscribe(response => this.getUsers());
  }
// Delete User
  deleteUser(id: number) {
    this.http.delete(usersUrl + '/' + id)
    .subscribe(response => this.getUsers());
  }

    //Stuff for UserType
    subscribeToUserTypeFetch(): Subject<boolean> {
        return this.userTypeListFetched;
      }
  // Get UserType
  getUserType(id: number) {
    this.http.get(userTypesUrl + '/' + id)
    .subscribe(response => this.userType = response);
  }
  // Get all UserTypes
  getUserTypes() {
    this.http.get(userTypesUrl)
    .subscribe(response => this.userType = response);
  }
  // Create UserType
  createUserType(newUserType: UserType) {
  this.http.post<UserType>(userTypesUrl, newUserType).subscribe(response => {
    newUserType.id = response.id;
    this.userTypes.push(newUserType);});
  }
// Update UserType
  replaceUserType(userTypeUpd: UserType) {
  const data = {
  name: userTypeUpd.name
    };
this.http.put(userTypesUrl + '/' + userTypeUpd.id, data ).subscribe(response => this.getUserTypes());
  }
// Delete UserType
  deleteUserType(id: number) {
    this.http.delete(userTypesUrl + '/' + id)
    .subscribe(response => this.getUserTypes());
  }
}

/*
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