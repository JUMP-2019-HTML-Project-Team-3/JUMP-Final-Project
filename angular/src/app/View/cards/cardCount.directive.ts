import { Directive, ElementRef, Input } from '@angular/core';

@Directive({ 
    selector: '[count]' 
    })

export class CardCountDirective {
    cardCount: any;
    
   constructor(el: ElementRef) {
       this.cardCount = 0;       
   }
      //el.nativeElement.id = ;
     private count() {
          this.cardCount++;
        console.log("Inside cardCount");
          console.log(this.cardCount);
          return this.cardCount;
      }
}