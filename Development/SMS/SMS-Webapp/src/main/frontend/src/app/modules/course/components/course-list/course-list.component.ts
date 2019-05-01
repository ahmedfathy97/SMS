import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../shared/services/course.service";
import {CourseResultSet} from "../../shared/data/course-result-set.data";
import {AngularFullRoutes, replaceCorID} from "../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss'],
  providers: [CourseService]
})
export class CourseListComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID : number ;



  constructor( private courseService: CourseService ) {

  }
  resultSet: CourseResultSet = new CourseResultSet();

  ngOnInit() {
    this.courseService.findAllCourses().subscribe(
      res=>this.resultSet = res
    );

  }

}
