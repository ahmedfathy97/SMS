import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {Announcement} from "../../../../../shared/data/announcment";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {CourseResultSet} from "../../../../../shared/data/course-result-set.data";

@Component({
  selector: 'app-view-announcment',
  templateUrl: './view-announcment.component.html',
  styleUrls: ['./view-announcment.component.scss'] ,
  providers: [CourseService]
})
export class ViewAnnouncmentComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  corID: number ;
  resultSet: CourseResultSet = new CourseResultSet();
  pageNum: number = 1;
  // announcmentList :Announcement[] ;
  constructor( private corDataService: CourseDataService ,
               private courseService :CourseService) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseAnnouncments();
      }
    );
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {

    this.getCourseAnnouncments();
  }

  getCourseAnnouncments()
  {
    this.courseService.getCourseAnnouncments(this.corID , this.pageNum).subscribe(res => {
      this.resultSet.announcList = res;
    }, err => {
      console.log(err);
    });
  }

  onPageChange(pageNum)
  {
    this.pageNum = pageNum ;
    this.getCourseAnnouncments();

  }
}
