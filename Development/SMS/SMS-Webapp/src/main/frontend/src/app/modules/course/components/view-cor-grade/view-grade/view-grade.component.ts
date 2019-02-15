import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../shared/services/course.service";
import {StdDTO} from "../../../shared/data/std-DTO.data";

@Component({
  selector: 'app-view-grade',
  templateUrl: './view-grade.component.html',
  styleUrls: ['./view-grade.component.scss'],
  providers:[CourseService]
})
export class ViewGradeComponent implements OnInit {

  constructor( private courseService: CourseService) { }
  studentList: StdDTO[] = [];
  ngOnInit() {
    this.courseService.getCourseGrades(2).subscribe(
      res=>this.studentList = res
    );
  }

}
