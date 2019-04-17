import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-course-side-bar',
  templateUrl: './course-side-bar.component.html',
  styleUrls: ['./course-side-bar.component.css']
})
export class CourseSideBarComponent implements OnInit {
  courseID: string;
  corID :number ;
  constructor(private route: ActivatedRoute ) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
      var courseID  = +this.courseID ;
      this.corID =courseID ;
      console.log(this.corID);
    })
  }

  ngOnInit() {


  }

}
