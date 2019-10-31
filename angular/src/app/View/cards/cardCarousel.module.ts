import { CardCarouselComponent } from './cardCarousel.component';
import { CardComponent } from './card.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardCountDirective } from './cardCount.directive';

@NgModule({
  imports: [
    CommonModule 
  ],
  declarations: [
    CardComponent, 
    CardCarouselComponent,
    CardCountDirective
  ],
  exports: [
    CardComponent,
    CardCarouselComponent 
  ]
})
export class CardCarouselModule { }
