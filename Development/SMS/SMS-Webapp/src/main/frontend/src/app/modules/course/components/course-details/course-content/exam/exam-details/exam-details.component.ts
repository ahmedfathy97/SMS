import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {QuizService} from "../../../../../shared/services/quiz.service";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";
import {ExamServices} from "../../../../../shared/services/exam.services";

@Component({
  selector: 'app-exam-details',
  templateUrl: './exam-details.component.html',
  styleUrls: ['./exam-details.component.css'] ,
  providers:[ExamServices]
})
export class ExamDetailsComponent implements OnInit {

  AUTH_VIEWS: typeof AuthViews = AuthViews;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  examID: number;
  examState:number;
  alert: AlertInput = new AlertInput();
  constructor(private corDataService: CourseDataService,
               private route: ActivatedRoute ,private examService :ExamServices) {
    this.route.paramMap.subscribe(params => {
      this.examID = +params.get("examID");
    })
    this.getExamState() ;
  }

  getExamState()
  {
    this.examService.getExamState(this.examID).subscribe(res => {
      this.examState = res ;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
