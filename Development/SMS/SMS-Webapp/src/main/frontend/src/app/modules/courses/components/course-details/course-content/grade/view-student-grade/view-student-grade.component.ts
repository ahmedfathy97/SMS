import { Component, OnInit } from '@angular/core';
import {StdDTO} from "../../../../../shared/data/std-dto.data";


import {CourseService} from "../../../../../shared/services/course.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-view-student-grade',
  templateUrl: './view-student-grade.component.html',
  styleUrls: ['./view-student-grade.component.scss'],
  providers: [CourseService]
})
export class ViewStudentGradeComponent implements OnInit {
  courseID : String ;
  constructor( private courseService: CourseService , private route: ActivatedRoute ) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
    })


  }
  students: StdDTO ;
  ngOnInit() {
    var courseID = +this.courseID ;
    this.courseService.getStudentGrades(courseID,6).subscribe(
      res=>this.students = res
    );
  }

}
