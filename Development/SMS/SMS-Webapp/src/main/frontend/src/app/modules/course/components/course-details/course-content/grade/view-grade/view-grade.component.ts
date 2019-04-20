import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../../../../../shared/services/course.service";
import {StdDTO} from "../../../../../shared/data/std-dto.data";
import {CourseDataService} from "../../../../../shared/services/course-data.service";

@Component({
  selector: 'app-view-grade',
  templateUrl: './view-grade.component.html',
  styleUrls: ['./view-grade.component.scss'],
  providers:[CourseService]
})
export class ViewGradeComponent implements OnInit {
  corID : number ;
  constructor( private courseService: CourseService , private corDataService: CourseDataService, private route: ActivatedRoute) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        this.getCourseGrade();
  }); this.corDataService.requestCorID.next(true);
  }

  studentList: StdDTO[] = [];
      getCourseGrade(){
      this.courseService.getCourseGrades(this.corID).subscribe(
        res=>this.studentList = res
      );

    }
  ngOnInit() {


  }

}
