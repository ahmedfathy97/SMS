import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../../../../../shared/services/course.service";
import {StdDTO} from "../../../../../shared/data/std-dto.data";

@Component({
  selector: 'app-view-grade',
  templateUrl: './view-grade.component.html',
  styleUrls: ['./view-grade.component.scss'],
  providers:[CourseService]
})
export class ViewGradeComponent implements OnInit {
  courseID : String ;
  constructor( private courseService: CourseService , private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
    })
  }
  studentList: StdDTO[] = [];
  ngOnInit() {
    var courseID = +this.courseID ;
    this.courseService.getCourseGrades(courseID).subscribe(
       res=>this.studentList = res
    );
  }

}
