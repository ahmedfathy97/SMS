import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../shared/services/course.service";
import {CourseVto} from "../../../../shared/data/course-vto";
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../../../shared/services/course-data.service";
import {AuthActions} from "../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AngularFullRoutes, replaceCorID, replaceUserID} from "../../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-view-course',
  templateUrl: './course-info.component.html',
  styleUrls: ['./course-info.component.css'],
  providers:[CourseService]
})
export class CourseInfoComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  replaceUserID =replaceUserID;


  corID : number ;
  viewData: CourseVto = new CourseVto();


  constructor(private corService: CourseService,private corDataService: CourseDataService){
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseInformation() ;
        this.corService.getStudentIsEnroll(this.corID).subscribe(res =>{
          this.isStudentEnroll = res;
          console.log(res);
        });
      }
    );
    this.corDataService.requestCorID.next(true);
  }
isStudentEnroll:boolean=false;

  getCourseInformation()
  {
    this.corService.getCourseByID(this.corID).subscribe(res => {  this.viewData = res ;});
  }

  ngOnInit() {
  }

  onEnrollNewStudent(){
    this.corService.enrollStudentByID(this.corID).subscribe(res => {
      console.log("Success");
      this.isStudentEnroll = true;
      location.reload();
  
    }, err => {
      console.log(err)});
  }




}
