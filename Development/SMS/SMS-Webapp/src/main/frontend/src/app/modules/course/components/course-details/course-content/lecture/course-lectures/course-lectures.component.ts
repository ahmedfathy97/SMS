import { Component, OnInit } from '@angular/core';
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {CourseService} from "../../../../../shared/services/course.service";
import {LectureVto} from "../../../../../shared/data/lecture-vto";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {LectureDataService} from "../../../../../shared/services/lecture-data.service";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";

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
  lectureList: LectureVto[];

  lectureID: number;

  currentDate: Date = new Date();

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
  }

  getCourseLectures(){
    this.courseService.getCourseLectures(this.corID).subscribe(res => {
      this.lectureList = res;
      for(let item of this.lectureList)
        item.lectureDate = new Date(item.lectureDate);
      console.log(this.lectureList);

    }, err => {
      console.log(err);
    });
  }

}
