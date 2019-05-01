import { Component, OnInit } from '@angular/core';
import {QuizService} from "../../../../../shared/services/quiz.service";
import {QuizInformationVto} from "../../../../../shared/data/quiz/quiz-information-vto";
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes ,replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../shared/services/course-data.service";

@Component({
  selector: 'app-quiz-main-detail',
  templateUrl: './quiz-main-detail.component.html',
  styleUrls: ['./quiz-main-detail.component.scss'] ,
  providers: [QuizService],
})
export class QuizMainDetailComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  //replaceQuizID = replaceQuizID;
  replaceCorID = replaceCorID;
  corID: number;
  quizId: number;
  quizDetials :QuizInformationVto ;

  constructor(private corDataService: CourseDataService,
              private quizService: QuizService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.quizId = +params.get("quizID");
    }) ,

      this.corDataService.corID.subscribe(
        data => {
          this.corID = data;
          console.log(data);
        }
      );

    this.corDataService.requestCorID.next(true);


  }


  ngOnInit() {
    this.getQuizInformation() ;
  }


  getQuizInformation() {

    this.quizService.getQuizDetails(this.quizId).subscribe(res => {
      this.quizDetials = res ;
    }, err => {
      console.log(err);
    });
  }

}
