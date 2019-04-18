import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../shared/services/course-data.service";

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  providers: [CourseDataService]
})
export class CourseDetailsComponent implements OnInit {
  // courseID: string;
  corID :number ;

  constructor(private route: ActivatedRoute,
              private corDataService: CourseDataService) {
    this.route.paramMap.subscribe(params => {
      this.corID = +params.get("courseID");
      // this.corDataService.corID.next(this.corID);


      // var courseID  = +this.courseID ;
      // this.corID =courseID ;
      // console.log(this.corID);
    });
    this.corDataService.requestCorID.subscribe(
      data => {
        this.corDataService.corID.next(this.corID);
      }
    )
  }

  ngOnInit() {
  }

}
