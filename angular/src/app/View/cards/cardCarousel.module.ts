import { CardCarouselComponent } from './cardCarousel.component';
import { CardComponent } from './card.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    CardComponent,
    CardCarouselComponent
  ],
  exports: [
    CardComponent,
    CardCarouselComponent
  ]
})
export class CardCarouselModule { }
