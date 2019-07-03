import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";
import {ActivatedRoute} from "@angular/router";
import {
  AngularFullRoutes,
  replaceCorID, replaceExamID,
  replaceQuizID
} from "../../../../../../../infrastructure/data/full-routes.enum";
import {CourseQuizesVto} from "../../../../../shared/data/quiz/course-quizes-vto";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {CourseExamsVto} from "../../../../../shared/data/quiz/course-exams-vto";

@Component({
  selector: 'app-course-exams',
  templateUrl: './course-exams.component.html',
  styleUrls: ['./course-exams.component.css'] ,
  providers: [CourseService]
})
export class CourseExamsComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  replaceExamID =replaceExamID;
  alert: AlertInput = new AlertInput();
  corID: number ;
  examList:CourseExamsVto[] ;
  constructor(private courseService: CourseService,
              private corDataService: CourseDataService,
              private route: ActivatedRoute ) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseExams();
      }
    );
    this.corDataService.requestCorID.next(true);
  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);

  }

  getCourseExams(){
    this.courseService.getCourseExams(this.corID).subscribe(res => {
      this.examList = res;
      // this.alert = new SuccessAlert();
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }


}
