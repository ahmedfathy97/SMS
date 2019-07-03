import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {FailureAlert} from "../../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {QuizResult} from "../../../../../../shared/data/quiz/quiz-result-dto";
import {AlertInput} from "../../../../../../../../infrastructure/components/alerts/alert-input";
import {ExamServices} from "../../../../../../shared/services/exam.services";
import {CourseService} from "../../../../../../shared/services/course.service";

@Component({
  selector: 'app-exam-result',
  templateUrl: './exam-result.component.html',
  styleUrls: ['./exam-result.component.css'] ,
  providers:[ExamServices, CourseService]
})
export class ExamResultComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID: number;
  examId: number;
  examResult : QuizResult[] ;
  alert: AlertInput = new AlertInput();
  constructor(private corDataService: CourseDataService,
              private courseService: CourseService,
              private examService: ExamServices, private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.examId = +params.get("examID");
    }) ,
      this.corDataService.corID.subscribe(
        data => {
          this.corID = data;
          console.log(data);
          this.getQuizResult();
        }
      );

    this.corDataService.requestCorID.next(true);

  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);

  }

  getQuizResult() {

    this.examService.getExamResult(this.examId).subscribe(res => {
      this.examResult = res ;
      console.log(this.examResult) ;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }

}
