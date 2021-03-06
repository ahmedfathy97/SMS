import {Component, Input, OnInit} from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
//import {Announcement} from "../../../../../shared/data/announcment";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {CourseResultSet} from "../../../../../shared/data/course-result-set.data";
import {ConfigParam} from "../../../../../../../infrastructure/common/config-param";
import {LocalStorageService} from "../../../../../../../infrastructure/services/local-storage.service";
import {AuthUserVTO} from "../../../../../../security/shared/data/auth-user-vto.data";

@Component({
  selector: 'app-view-announcment',
  templateUrl: './view-announcment.component.html',
  styleUrls: ['./view-announcment.component.scss'] ,
  providers: [CourseService]
})
export class ViewAnnouncmentComponent implements OnInit {
  @Input() inCourseHome: boolean = false;
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  corID: number ;
  resultSet: CourseResultSet = new CourseResultSet();
  pageNum: number = 1;
  PAGE_SIZE: number = ConfigParam.PAGE_SIZE;
  
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

  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);

    this.getCourseAnnouncments();
  
  }

  getCourseAnnouncments()
  {
    this.courseService.getCourseAnnouncments(this.corID , this.pageNum ).subscribe(
      res => {
      this.resultSet = res;
      console.log(res);
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
