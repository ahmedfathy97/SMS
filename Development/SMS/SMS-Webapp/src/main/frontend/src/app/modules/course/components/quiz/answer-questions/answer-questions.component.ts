import {Component, OnInit} from '@angular/core';
import {QuestionVto} from "../../../shared/data/quiz/question-vto";
import {QuizService} from "../../../shared/services/quiz.service";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-answer-questions',
  templateUrl: './answer-questions.component.html',
  styleUrls: ['./answer-questions.component.scss'],
  providers: [QuizService]
})
export class AnswerQuestionsComponent implements OnInit {

  constructor(private quizService: QuizService) {
  }

  quizID: number = 1;
  quizQuestions: QuestionVto[] = [];
  isMCQQuestion: boolean = false;
  isTrueFaleQuestion: boolean = false;
  isTextualQuestion: boolean = false;


  getQuizQuestions() {
    this.quizService.getQuizQuestions(this.quizID).subscribe(res => {
      console.log("Success");
      this.quizQuestions = res;
    }, err => {
      console.log(err);
    });
  }


  ngOnInit() {
    this.getQuizQuestions();
  }

}

// for (let item of this.quizQuestions) {
//   switch (item.questionTypeID) {
//     case 1 :
//       this.isMCQQuestion = true;
//       this.isTrueFaleQuestion = false;
//       this.isTextualQuestion = false;
//       break;
//     case 2 :
//       this.isMCQQuestion = false;
//       this.isTrueFaleQuestion = true;
//       this.isTextualQuestion = false;
//       break;
//     case 3 :
//       this.isMCQQuestion = false;
//       this.isTrueFaleQuestion = false;
//       this.isTextualQuestion = true;
//       break;
//     default :
//       break;
//   }
// }


// if(item.questionTypeID == 1)
// {
//   this.isMCQQuestion =true ;
//   this.isTrueFaleQuestion =false ;
//   this.isTextualQuestion =false ;
// } else if(item.questionTypeID ==2)
// {
//
//   this.isMCQQuestion = false ;
//   this.isTrueFaleQuestion =true ;
//   this.isTextualQuestion =false ;
// }else if(item.questionTypeID ==3)
// {
//   this.isMCQQuestion =false ;
//   this.isTrueFaleQuestion =false ;
//   this.isTextualQuestion =true ;
// } else {
//
// }

