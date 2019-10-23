import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser"
import { RouterModule } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { InstructorHomeComponent } from "./instructorHome.component";

@NgModule({
    imports: [BrowserModule, RouterModule, FormsModule],
    declarations: [
      InstructorHomeComponent
    ]
})
export class InstructorModule { }
