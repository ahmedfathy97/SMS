import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {QuizInformationVto} from "../../../../../../shared/data/quiz/quiz-information-vto";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {AngularFullRoutes ,replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";

@Component({
  selector: 'app-quiz-main-detail',
  templateUrl: './quiz-main-detail.component.html',
  styleUrls: ['./quiz-main-detail.component.scss'] ,
  providers: [QuizService],
})
export class QuizMainDetailComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  //replaceQuizID = replaceQuizID;
  replaceCorID = replaceCorID;
  corID: number;
  quizId: number;
  quizDetails :QuizInformationVto ;

  constructor(private corDataService: CourseDataService,
              private quizService: QuizService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.quizId = +params.get("quizID");
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


  ngOnInit() {
  }


  getQuizInformation() {

    this.quizService.getQuizDetails(this.quizId).subscribe(res => {
      this.quizDetails = res ;
    }, err => {
      console.log(err);
    });
  }


  onClickCloseQuiz()
  {
    this.quizService.closeQuiz(this.quizId).subscribe(res => {
    }, err => {
      console.log(err);
    });
  }

}
