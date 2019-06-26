import { Component, OnInit } from '@angular/core';
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {CourseService} from "../../../../../shared/services/course.service";
import {LectureVto} from "../../../../../shared/data/lecture-vto";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {LectureDataService} from "../../../../../shared/services/lecture-data.service";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {CourseResultSet} from "../../../../../shared/data/course-result-set.data";

@Component({
  selector: 'app-course-lectures',
  templateUrl: './course-lectures.component.html',
  styleUrls: ['./course-lectures.component.scss'] ,
  providers: [CourseService]
})
export class CourseLecturesComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  replaceLecID = replaceLecID;

  corID: number ;


  lectureID: number;

  currentDate: Date = new Date();
  resultSet: CourseResultSet = new CourseResultSet();
  pageNum:number=1;

  constructor(private corDataService: CourseDataService,
              private courseService: CourseService,
              private lecDataSer: LectureDataService) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseLectures();
      }
    );
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {
    this.getCourseLectures();
  }

  getCourseLectures(){
    this.courseService.getCourseLectures(this.corID,this.pageNum).subscribe(res => {
      this.resultSet = res;
      for(let item of this.resultSet.lectureList)
        item.lectureDate = new Date(item.lectureDate);
      console.log(this.resultSet);

    }, err => {
      console.log(err);
    });
  }
  onPageChange(pageNum){
    this.pageNum = pageNum;
    this.getCourseLectures();
  }

}
