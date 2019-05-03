import { Component, OnInit } from '@angular/core';
import {AngularFullRoutes, replaceCorID ,replaceQuizID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {ActivatedRoute} from "@angular/router";
import {QuizService} from "../../../../../shared/services/quiz.service";
import {CourseDataService} from "../../../../../shared/services/course-data.service";

@Component({
  selector: 'app-quiz-details',
  templateUrl: './quiz-details.component.html',
  styleUrls: ['./quiz-details.component.scss'] ,
  providers:[QuizService]
})
export class QuizDetailsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceQuizID = replaceQuizID;
  replaceCorID = replaceCorID;
  quizId: number;
  quizState:number;
  constructor(private corDataService: CourseDataService,
              private quizService: QuizService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.quizId = +params.get("quizID");
      this.quizService.getQuizState(this.quizId).subscribe(res => {
        this.quizState = res ;
      }, err => {
        console.log(err);
      });
    })


  }

  ngOnInit() {
  }

}
