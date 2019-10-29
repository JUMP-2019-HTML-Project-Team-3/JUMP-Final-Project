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
import { Login } from './login.model';
/* import { StaticDataSource } from "./static.datasource";
When Angular needs to create a new instance of the repository,
it will inspect the class and see that it needs a StaticDataSourceobject
to invoke the Repository constructor and create a new object. */

const API_ENDPOINT = 'http://localhost:8080';
const addressesUrl = API_ENDPOINT + '/cognixia/alladdresses';
const clientsUrl = API_ENDPOINT + '/cognixia/alllients';
const instructorsUrl = API_ENDPOINT + '/cognixia/allinstructors';
const locationsUrl = API_ENDPOINT + '/cognixia/alllocations';
const resourcesUrl = API_ENDPOINT + '/cognixia/allresources';
const studentsUrl = API_ENDPOINT + '/cognixia/allstudents';
const toolsUrl = API_ENDPOINT + '/cognixia/alltools';
const usersUrl = API_ENDPOINT + '/cognixia/allusers';
const userTypesUrl = API_ENDPOINT + 'userTypes';

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
    login: Login;
    users: User[];
    userType: UserType;
    userTypes: UserType[];

    constructor(private http: HttpClient) {
    // this.getAddresses();
    // this.getClients();
    // this.getInstructors();
    this.getLocations();
    // this.getResources();
    this.getStudents();
    //this.getStudent(id);
    // this.getTools();
    // this.getUsers();
    // this.getUserTypes();
  }

    // Stuff for Address
    subscribeToAddressFetch(): Subject<boolean> {
        return this.addressListFetched;
      }

    // Get one Address
    getAddress(id: number) {
        this.http.get(addressesUrl + '/' + id)
          .subscribe(response => this.address = response);
      }

    // Get All Addresses
    getAddresses() {
        this.http.get(addressesUrl)
        .subscribe(response => this.address = response);
    }

    // Create New Address
    createAddress(newAddress: Address) {
      this.http.post<Address>(addressesUrl, newAddress).subscribe(response => {
          newAddress.id = response.id;
          this.addresses.push(newAddress);
        });
      }

    // Update Address
    replaceAddress(address1: Address) {
      const data = {
      streetNumber: address1.streetNumber, streetName: address1.streetName, suiteNo: address1.suiteNo,
      township: address1.township, zip: address1.zip, country: address1.country
    };
      this.http.put(addressesUrl + '/' + address1.id, data ).subscribe(response => this.getAddresses());
  }

    // Delete Address
    deleteAddress(id: number) {
      this.http.delete(addressesUrl + '/' + id)
    .subscribe(response => this.getAddresses());
  }

    // Stuff for Client
    subscribeToClientFetch(): Subject<boolean> {
        return this.clientListFetched;
      }

    // Get One Client
    getClient(id: number) {
        this.http.get(clientsUrl + '/' + id)
          .subscribe(response => this.client = response);
      }

    // Get All Clients
    getClients() {
        this.http.get(clientsUrl)
        .subscribe(response => this.client = response);
        }

    // Create New Client
    createClient(newClient: Client) {
      this.http.post<Client>(clientsUrl, newClient).subscribe(response => {
          newClient.id = response.id;
          this.clients.push(newClient);
        });
      }

    // Update Client
    replaceClient(client1: Client) {
      const data = {
      imagePath: client1.imagePath, name: client1.name, phone: client1.phone,
      description: client1.description, address: client1.address
    };
      this.http.put(clientsUrl + '/' + client1.id, data ).subscribe(response => this.getClients());
  }

    // Delete Client
    deleteClient(id: number) {
      this.http.delete(clientsUrl + '/' + id)
    .subscribe(response => this.getClients());
  }


    // Stuff for Instructor
    subscribeToInstructorFetch(): Subject<boolean> {
        return this.instructorListFetched;
      }


    // Get One Instructor
    getInstructor(id: number) {
        this.http.get(instructorsUrl + '/' + id)
          .subscribe(response => this.instructor = response);
      }


    // Get All Instructors
    getInstructors() {
        this.http.get<Instructor[]>(instructorsUrl)
        .subscribe(response => this.instructors = response);
        };

    // Create New Instructor
    createInstructors(newInstructor: Instructor) {
      this.http.post<Instructor>(instructorsUrl, newInstructor).subscribe(response => {
          newInstructor.id = response.id;
          this.clients.push(newInstructor);
        });
      }

    // Update Instructor
    replaceInstructor(instructor1: Instructor) {
      const data = {
      imagePath: instructor1.imagePath, firstName: instructor1.firstName, lastName: instructor1.lastName,
      description: instructor1.description, user: instructor1.user, userType: instructor1.userType,
      students: instructor1.students, resources: instructor1.resources, tools: instructor1.tools
    };
      this.http.put(instructorsUrl + '/' + instructor1.id, data ).subscribe(response => this.getInstructors());
  }

    // Delete Instructor
    deleteInstructor(id: number) {
      this.http.delete(instructorsUrl + '/' + id)
    .subscribe(response => this.getInstructors());
  }

    // Stuff for Location
    subscribeToLocationFetch(): Subject<boolean> {
        return this.locationListFetched;
      }

    // Get One Location
    getLocation(id: number) {
        this.http.get(locationsUrl + '/' + id)
          .subscribe(response => this.location = response);
      }

    // Get All Locations
    getLocations() {
        this.http.get<Location[]>(locationsUrl)
        .subscribe(response => this.locations = response);
        }

    // Create New Location
    createLocation(newLocation: Location) {
      this.http.post<Location>(locationsUrl, newLocation).subscribe(response => {
          newLocation.id = response.id;
          this.locations.push(newLocation);
        });
      }

    // Update Location
    replaceLocation(location1: Location) {
      const data = {
      imagePath: location1.imagePath, name: location1.name, phoneNo: location1.phoneNo,
      address: location1.address, students: location1.students, instructors: location1.instructors
        };
      this.http.put(locationsUrl + '/' + location1.id, data ).subscribe(response => this.getLocations());
  }

    // Delete Location
    deleteLocation(id: number) {
      this.http.delete(locationsUrl + '/' + id)
    .subscribe(response => this.getLocations());
  }

    // Stuff for Resource
    subscribeToResourceFetch(): Subject<boolean> {
        return this.resourceListFetched;
      }

    // Get One Resource
    getResource(id: number) {
        this.http.get(resourcesUrl + '/' + id)
          .subscribe(response => this.resource = response);
      }

    // Get All Resource
    getResources() {
        this.http.get(resourcesUrl)
        .subscribe(response => this.resource = response);
        }

    // Create New Resource
    createResource(newResource: Resource) {
      this.http.post<Resource>(resourcesUrl, newResource).subscribe(response => {
          newResource.id = response.id;
          this.resources.push(newResource);
        });
      }

    // Update Resource
    replaceResource(resource1: Resource) {
      const data = {
      name: resource1.name, link: resource1.link, description: resource1.description
        };
      this.http.put(resourcesUrl + '/' + resource1.id, data ).subscribe(response => this.getResources());
  }

    // Delete Resource
    deleteResource(id: number) {
      this.http.delete(resourcesUrl + '/' + id)
    .subscribe(response => this.getResources());
  }

    // Stuff for Student
    subscribeToStudentFetch(): Subject<boolean> {
        console.log("this.studentListFetched ");
        console.log(this.studentListFetched);
        return this.studentListFetched;
      }
    // Get Student
    getStudent(id: number) {
        this.http.get(studentsUrl + '/' + id)
        .subscribe(response => this.student = response);
      }
    // Get all Students
    getStudents() {
        //this.http.get(studentsUrl)
        //.subscribe(response => this.student = response);

        this.http.get<Student[]>(studentsUrl)
        .subscribe(response => this.students = response);

        //let url = studentsUrl;

        //this.http.get<any>(url).subscribe(response => this.students = response);
         //this.studentListFetched.next(true);
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




    // Stuff for User
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

    // Stuff for UserType
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