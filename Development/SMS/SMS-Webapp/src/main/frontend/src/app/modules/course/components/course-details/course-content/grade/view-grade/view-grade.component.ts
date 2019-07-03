import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../../../../../shared/services/course.service";
import {StdDTO} from "../../../../../shared/data/std-dto.data";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {CourseResultSet} from "../../../../../shared/data/course-result-set.data";

@Component({
  selector: 'app-view-grade',
  templateUrl: './view-grade.component.html',
  styleUrls: ['./view-grade.component.scss'],
  providers: [CourseService]
})
export class ViewGradeComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  // display:boolean=false;
  corID: number;
  
  constructor(private courseService: CourseService, private corDataService: CourseDataService, private route: ActivatedRoute) {
    this.corDataService.corID.subscribe(
      data => {
        this.corID = data;
        this.getCourseGrade();
      });
    this.corDataService.requestCorID.next(true);
  }
  
  // studentList: StdDTO[] = [];
  getCourseGrade() {
    this.courseService.getCourseGrades(this.corID, this.pageNum).subscribe(
      res => {
        this.resultSet = res;
        console.log(res);
      }
    );
//       if(this.studentList.length != 0){
//        this.display=true;
// }
  }
  
  resultSet: CourseResultSet = new CourseResultSet();
  pageNum: number = 1;
  corName: string;
  
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
    
    this.getCourseGrade()
  }
  
  onPageChange(pageNum) {
    this.pageNum = pageNum;
    this.getCourseGrade();
  }
}
