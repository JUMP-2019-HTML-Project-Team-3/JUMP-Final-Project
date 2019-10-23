// import { NavbarComponent } from './../../navbar/navbar.component';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { InstructorHomeComponent } from './instructorHome.component';
import { LocationListComponent } from './Lists/locationList.component';

@NgModule({
    schemas: [
    CUSTOM_ELEMENTS_SCHEMA
    ],
    imports: [
      BrowserModule,
      RouterModule,
      FormsModule
    ],
    declarations: [
      InstructorHomeComponent,
      LocationListComponent
      // NavbarComponent
    ],
    providers: [

    ]
})
export class InstructorModule { }
