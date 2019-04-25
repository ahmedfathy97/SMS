import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../shared/services/course.service";
import {ActivatedRoute} from "@angular/router";
import {CourseVto} from "../../shared/data/course-vto";
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
    // this.route.paramMap.subscribe(params => {
    //   this.courseID = params.get("courseID");
    // })
  }
// courseList:CourseVto[]=[] ;
  resultSet: CourseResultSet = new CourseResultSet();
  ngOnInit() {
    // var courseID = +this.courseID ;
    this.courseService.findAllCourses().subscribe(
      res=>this.resultSet = res
    );
  }

}
