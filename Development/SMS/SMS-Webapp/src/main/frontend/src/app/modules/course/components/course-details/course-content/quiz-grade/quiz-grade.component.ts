import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../shared/services/course.service";
import {StdDTO} from "../../../../shared/data/std-dto.data";
import {AngularFullRoutes, replaceCorID} from "../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";

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
  studentQuiz: StdDTO[] = [];

  constructor(private courseService: CourseService) { }

  ngOnInit() {
    this.getQuizGrades();


  }
  getQuizGrades(){
    this.courseService.getQuizGrades(this.corID).subscribe(res=>{this.studentQuiz=res
    },err=>{console.log(err);});

  }

}
