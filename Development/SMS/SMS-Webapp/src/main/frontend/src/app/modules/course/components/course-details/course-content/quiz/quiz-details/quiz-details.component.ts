import {Component, OnInit} from '@angular/core';
import {QuizService} from "../../../../../shared/services/quiz.service";
import {
  AngularFullRoutes,
  replaceCorID,
  replaceQuizID
} from "../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {ActivatedRoute} from "@angular/router";
import {QuizInformationVto} from "../../../../../shared/data/quiz/quiz-information-vto";

@Component({
  selector: 'app-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.scss'],
  providers: [QuizService],
})
export class QuizDetailsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceQuizID = replaceQuizID;
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
