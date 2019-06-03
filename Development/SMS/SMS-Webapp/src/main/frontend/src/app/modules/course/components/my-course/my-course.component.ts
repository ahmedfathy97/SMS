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
  pageNum: number = 1;
  ngOnInit() {
    this.onSearch()

  }
  onSearch(){
    this.courseService.findAllMyCourses(this.pageNum).subscribe(
      res=>this.resultSet = res
    );
  }
  onPageChange(pageNum){
    this.pageNum = pageNum;
    this.onSearch();
  }

}
