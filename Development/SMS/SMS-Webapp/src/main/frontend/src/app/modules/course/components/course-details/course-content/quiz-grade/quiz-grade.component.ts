import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../shared/services/course.service";
import {StdDTO} from "../../../../shared/data/std-dto.data";
import {AngularFullRoutes, replaceCorID} from "../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {GradeService} from "../../../../shared/services/grade.service";
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../../../shared/services/course-data.service";

@Component({
  selector: 'app-quiz-grade',
  templateUrl: './quiz-grade.component.html',
  styleUrls: ['./quiz-grade.component.scss'],
  providers:[CourseService]
})
export class QuizGradeComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  corID :number ;
  quizCount: number;
  Arr = Array; //Array type captured in a variable
  studentQuiz: StdDTO[] = [];

  constructor(
    private courseService: CourseService,private route: ActivatedRoute,
              private corDataService: CourseDataService) {
    this.corDataService.corID.subscribe(data=>{this.corID=data; console.log(data);this.getQuizGrades();});
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {
    this.getQuizGrades();


  }
  getQuizGrades(){
    this.courseService.getCourseQuizes(this.corID).subscribe(res=>{
      this.quizCount = res.length;
    });
    this.courseService.getQuizGrades(this.corID).subscribe(res=>{

      this.studentQuiz=res;
      console.log(res);


    },err=>{console.log(err);
    });

  }

}
