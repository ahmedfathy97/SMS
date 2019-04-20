import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../shared/services/course.service";
import {CourseVto} from "../../../../shared/data/course-vto";
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../../../shared/services/course-data.service";

@Component({
  selector: 'app-view-course',
  templateUrl: './course-info.component.html',
  styleUrls: ['./course-info.component.css'],
  providers:[CourseService]
})
export class CourseInfoComponent implements OnInit {

  corID : number ;
  viewData: CourseVto = new CourseVto();


  constructor(private corService: CourseService,private corDataService: CourseDataService){
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseInformation() ;
      }
    );
    this.corDataService.requestCorID.next(true);
  }


  getCourseInformation()
  {
    this.corService.getCourseByID(this.corID).subscribe(res => {  this.viewData = res ;});
  }

  ngOnInit() {
  }

  onEnrollNewStudent(){
    this.corService.enrollStudentByID(this.corID).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err)});
  }




}
