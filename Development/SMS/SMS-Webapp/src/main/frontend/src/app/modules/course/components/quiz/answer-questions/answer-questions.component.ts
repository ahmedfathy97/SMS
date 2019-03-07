import { Component, OnInit } from '@angular/core';
import {QuestionVto} from "../../../shared/data/quiz/question-vto";
import {QuizService} from "../../../shared/services/quiz.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-answer-questions',
  templateUrl: './answer-questions.component.html',
  styleUrls: ['./answer-questions.component.scss'] ,
  providers:[QuizService]
})
export class AnswerQuestionsComponent implements OnInit {

  constructor(private quizService :QuizService) { }
  quizID:number= 1 ;
  quizQuestions :QuestionVto[] ;

  getQuizQuestions()
  {
    this.quizService.getQuizQuestions(this.quizID).subscribe(res => {
      console.log("Success");
      this.quizQuestions =res ;
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
    this.getQuizQuestions() ;
  }

}
