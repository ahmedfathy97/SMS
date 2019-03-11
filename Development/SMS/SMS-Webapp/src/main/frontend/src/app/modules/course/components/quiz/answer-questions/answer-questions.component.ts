import {Component, OnInit} from '@angular/core';
import {QuestionVto} from "../../../shared/data/quiz/question-vto";
import {QuizService} from "../../../shared/services/quiz.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {StudentAnswerDto} from "../../../shared/data/quiz/student-answer-dto";

@Component({
  selector: 'app-answer-questions',
  templateUrl: './answer-questions.component.html',
  styleUrls: ['./answer-questions.component.scss'],
  providers: [QuizService ,FormBuilder]
})
export class AnswerQuestionsComponent implements OnInit {

  constructor(private formBuilder: FormBuilder ,
              private quizService: QuizService) {
  }

  studentID: number =1 ;
  quizID: number = 1;
  quizQuestions: QuestionVto[] =[];
  studentAnswers:StudentAnswerDto[] =[] ;



  formData: FormGroup = this.formBuilder.group({
    questionID :null ,
    studentAnswer:null ,
  }) ;

  getQuizQuestions() {

    this.quizService.getQuizQuestions(this.quizID).subscribe(res => {
      console.log("Success");
      this.quizQuestions = res;
    }, err => {
      console.log(err);
    });
  }

  onSubmitAnswers()
  {
    let studentAnswer :StudentAnswerDto =new StudentAnswerDto();
    for(let question of this.quizQuestions)
    {
      studentAnswer.questionID =question.id ;
      studentAnswer.studentAnswer= this.formData.get('studentAnswer').value ;
      this.studentAnswers.push(studentAnswer);
    }

    this.quizService.submitQuizAnswersForStudent(this.studentID ,this.quizID,this.studentAnswers).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    } );
  }

  ngOnInit() {
    this.getQuizQuestions();
  }

}



