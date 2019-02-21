import { Component, OnInit } from '@angular/core';
import {StdDTO} from "../../../shared/data/std-dto.data";


import {CourseService} from "../../../shared/services/course.service";

@Component({
  selector: 'app-view-student-grade',
  templateUrl: './view-student-grade.component.html',
  styleUrls: ['./view-student-grade.component.scss'],
  providers: [CourseService]
})
export class ViewStudentGradeComponent implements OnInit {

  constructor( private courseService: CourseService ) { }
  students: StdDTO ;
  ngOnInit() {
    this.courseService.getStudentGrades(4,6).subscribe(
      res=>this.students = res
    );
  }

}
