import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {QuizResult} from "../../../../../../shared/data/quiz/quiz-result-dto";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {AngularFullRoutes ,replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {AlertInput} from "../../../../../../../../infrastructure/components/alerts/alert-input";
import {FailureAlert} from "../../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {CourseService} from "../../../../../../shared/services/course.service";

@Component({
  selector: 'app-quiz-result',
  templateUrl: './quiz-result.component.html',
  styleUrls: ['./quiz-result.component.css'],
  providers: [QuizService, CourseService],
})
export class QuizResultComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID: number;
  quizId: number;
  quizResult : QuizResult[] ;
  alert: AlertInput = new AlertInput();
  constructor(private corDataService: CourseDataService,
              private courseService: CourseService,
              private quizService: QuizService, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.quizId = +params.get("examID");
    }) ,
      this.corDataService.corID.subscribe(
        data => {
          this.corID = data;
          console.log(data);
        }
      );

    this.corDataService.requestCorID.next(true);

  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
    this.getQuizResult();
  }

  getQuizResult() {

    this.quizService.getQuizResult(this.quizId).subscribe(res => {
      this.quizResult = res ;
      console.log(this.quizResult) ;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }
}
