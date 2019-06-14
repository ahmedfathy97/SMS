import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {QuizInformationVto} from "../../../../../../shared/data/quiz/quiz-information-vto";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {FailureAlert} from "../../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {AlertInput} from "../../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../../infrastructure/components/alerts/success-alert.data";
import {AuthActions} from "../../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {ExamServices} from "../../../../../../shared/services/exam.services";
import {ExamInformationVto} from "../../../../../../shared/data/quiz/exam-information-vto";

@Component({
  selector: 'app-exam-main-detail',
  templateUrl: './exam-main-detail.component.html',
  styleUrls: ['./exam-main-detail.component.css'] ,
  providers :[ExamServices] ,
})
export class ExamMainDetailComponent implements OnInit {

  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  //replaceQuizID = replaceQuizID;
  replaceCorID = replaceCorID;
  corID: number;
  examId: number;
  examDetails :ExamInformationVto ;
  alert: AlertInput = new AlertInput();
  constructor(private corDataService: CourseDataService,
              private examService: ExamServices, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.examId = +params.get("examID");
    }) ,

      this.corDataService.corID.subscribe(
        data => {
          this.corID = data;
          console.log(data);
          this.getExamInformation() ;
        }
      );

    this.corDataService.requestCorID.next(true);


  }


  ngOnInit() {
  }


  getExamInformation() {

    this.examService.getExamDetails(this.examId).subscribe(res => {
      this.examDetails = res ;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }


  onClickCloseExam()
  {
    this.examService.closeExam(this.examId).subscribe(res => {
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }


}
