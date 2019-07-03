import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {QuizInformationVto} from "../../../../../../shared/data/quiz/quiz-information-vto";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {
  AngularFullRoutes,
  replaceCorID,
  replaceQuizID
} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AlertInput} from "../../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../../infrastructure/components/alerts/success-alert.data";
import {FailureAlert} from "../../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {CourseService} from "../../../../../../shared/services/course.service";

@Component({
  selector: 'app-quiz-main-detail',
  templateUrl: './quiz-main-detail.component.html',
  styleUrls: ['./quiz-main-detail.component.scss'] ,
  providers: [QuizService, CourseService],
})
export class QuizMainDetailComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceQuizID = replaceQuizID;
  replaceCorID = replaceCorID;
  corID: number;
  quizID: number;
  quizDetails :QuizInformationVto ;
  alert: AlertInput = new AlertInput();
  constructor(private corDataService: CourseDataService,
              private courseService: CourseService,
              private quizService: QuizService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.quizID = +params.get("quizID");
    }) ,

      this.corDataService.corID.subscribe(
        data => {
          this.corID = data;
          console.log(data);
          this.getQuizInformation() ;
        }
      );

    this.corDataService.requestCorID.next(true);


  }
  
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
  }


  getQuizInformation() {

    this.quizService.getQuizDetails(this.quizID).subscribe(res => {
      this.quizDetails = res ;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }


  onClickCloseQuiz()
  {
    this.quizService.closeQuiz(this.quizID).subscribe(res => {
      this.alert = new SuccessAlert();
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }

}
