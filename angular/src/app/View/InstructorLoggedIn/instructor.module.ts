// Module Imports
import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {CardCarouselModule} from '../cards/cardCarousel.module';
// Component Imports 
import { InstructorHomeComponent } from './instructorHome.component';
import { LocationListComponent } from './Lists/locationList.component';
//import { ResourceListComponent } from './Lists/resourceList.component';
 

@NgModule({
    schemas: [
    CUSTOM_ELEMENTS_SCHEMA
    ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    CardCarouselModule 
  ],
    declarations: [
      InstructorHomeComponent,
      LocationListComponent
      //ResourceListComponent
    ],
    providers: [

    ]
})
export class InstructorModule { }
