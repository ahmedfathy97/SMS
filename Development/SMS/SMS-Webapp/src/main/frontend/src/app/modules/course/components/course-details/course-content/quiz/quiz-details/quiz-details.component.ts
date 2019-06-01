import { Component, OnInit } from '@angular/core';
import {AngularFullRoutes, replaceCorID ,replaceQuizID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {ActivatedRoute} from "@angular/router";
import {QuizService} from "../../../../../shared/services/quiz.service";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";

@Component({
  selector: 'app-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.scss'] ,
  providers:[QuizService]
})
export class QuizDetailsComponent implements OnInit {
  AUTH_VIEWS: typeof AuthViews = AuthViews;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceQuizID = replaceQuizID;
  replaceCorID = replaceCorID;
  quizId: number;
  quizState:number;
  alert: AlertInput = new AlertInput();
  constructor(private corDataService: CourseDataService,
              private quizService: QuizService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.quizId = +params.get("quizID");
      this.quizService.getQuizState(this.quizId).subscribe(res => {
        this.quizState = res ;
        this.alert = new SuccessAlert();
      }, err => {
        this.alert = new FailureAlert(err);
        console.log(err);
      });
    })


  }

  ngOnInit() {
  }

}
