import { CardCarouselComponent } from './cardCarousel.component';
import { CardComponent } from './card.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardCountDirective } from './cardCount.directive';
import { CardCarouselItemComponent } from './cardCarouselItem.component';

@NgModule({
  imports: [
    CommonModule 
  ],
  declarations: [
    CardComponent, 
    CardCarouselComponent,
    CardCarouselItemComponent,
    CardCountDirective
  ],
  exports: [
    CardComponent,
    CardCarouselComponent,
    CardCarouselItemComponent
  ]
})
export class CardCarouselModule { }
