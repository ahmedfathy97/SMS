import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../shared/services/course.service";
import {CourseVto} from "../../shared/data/course-vto";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-view-course',
  templateUrl: './view-course.component.html',
  styleUrls: ['./view-course.component.css'],
  providers:[CourseService]
})
export class ViewCourseComponent implements OnInit {

  corID : string ;
  private viewData: CourseVto = new CourseVto();


  constructor(private corService: CourseService,
              private route : ActivatedRoute) {
    this.route.paramMap.subscribe(params =>{
      this.corID = params.get("corID");
    })
  }


  ngOnInit() {
    var courseID = +this.corID;
    this.corService.getCourseByID(courseID).subscribe(res => {  this.viewData = res ;});
  }

}
