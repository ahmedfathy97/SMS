import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../shared/services/course.service";
import {CourseResultSet} from "../../shared/data/course-result-set.data";
import {AngularFullRoutes, replaceCorID} from "../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {ConfigParam} from "../../../../infrastructure/common/config-param";

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.scss'],
  providers: [CourseService]
})
export class CourseListComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID : number ;

  PAGE_SIZE: number = ConfigParam.PAGE_SIZE;


  constructor( private courseService: CourseService ) {

  }
  resultSet: CourseResultSet = new CourseResultSet();
  pageNum: number = 1;
  ngOnInit() {
    this.onSearch();
  }


  onSearch(){

    this.courseService.findAllCourses(this.pageNum).subscribe(
      res=>this.resultSet = res
    );
  }

  onPageChange(pageNum){
    this.pageNum = pageNum;
    this.onSearch();
  }

}
