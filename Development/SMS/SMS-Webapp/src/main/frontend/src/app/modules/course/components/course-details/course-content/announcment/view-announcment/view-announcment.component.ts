import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {Announcement} from "../../../../../shared/data/announcment";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-view-announcment',
  templateUrl: './view-announcment.component.html',
  styleUrls: ['./view-announcment.component.scss'] ,
  providers: [CourseService]
})
export class ViewAnnouncmentComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  corID: number ;
  announcmentList :Announcement[] ;
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
  }

  getCourseAnnouncments()
  {
    this.courseService.getCourseAnnouncments(this.corID).subscribe(res => {
      this.announcmentList = res;
    }, err => {
      console.log(err);
    });
  }

}
