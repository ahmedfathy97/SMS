import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../shared/services/course.service";
import {AngularFullRoutes, replaceCorID} from "../../../../infrastructure/data/full-routes.enum";
import {CourseResultSet} from "../../shared/data/course-result-set.data";

@Component({
  selector: 'app-my-course',
  templateUrl: './my-course.component.html',
  styleUrls: ['./my-course.component.scss'],
  providers: [CourseService]
})
export class MyCourseComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID : number ;

  constructor(private courseService: CourseService) { }
  resultSet: CourseResultSet = new CourseResultSet();
  ngOnInit() {
    this.courseService.findAllMyCourses().subscribe(
      res=>this.resultSet = res
    );
  }

}
