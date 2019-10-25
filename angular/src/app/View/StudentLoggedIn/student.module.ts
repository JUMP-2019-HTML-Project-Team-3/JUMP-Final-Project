import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { StudentHomeComponent } from './studentHome.component';
import {CardCarouselModule} from '../cards/cardCarousel.module';

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
      StudentHomeComponent,
      // NavbarComponent
    ],
    providers: [

    ]
})
export class StudentModule { }
