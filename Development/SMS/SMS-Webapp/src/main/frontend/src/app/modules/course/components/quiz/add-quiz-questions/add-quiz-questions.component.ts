import { Component, OnInit } from '@angular/core';
import {QuizService} from "../../../shared/services/quiz.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuestionType} from "../../../shared/data/quiz/question-type";
import {QuestionDto} from "../../../shared/data/quiz/question-dto";

@Component({
  selector: 'app-add-quiz-quiestions',
  templateUrl: './add-quiz-questions.component.html',
  styleUrls: ['./add-quiz-questions.component.scss'] ,
  providers:[FormBuilder ,QuizService]
})
export class AddQuizQuestionsComponent implements OnInit {

  constructor(private formBuilder: FormBuilder ,
              private quizService :QuizService) { }

  questionTypeList :QuestionType [] ;

  getALLquestionsTypes()
  {
    this.quizService.getAllQuestionsTypes().subscribe(res => {
      console.log("Success");
      this.questionTypeList =res ;
    }, err => {
      console.log(err);
    });
  }

  formData: FormGroup = this.formBuilder.group({
    question:null ,
    modelAnswer:null ,
    questionTypeID:null
  }) ;

 onclickAddQuestion(question:QuestionDto)
 {
   let questionData :QuestionDto =new QuestionDto() ;
   questionData.question =this.formData.get('question').value;
   questionData.modelAnswer =this.formData.get('modelAnswer').value;
 }



  // onclickoption(event:any)
  // {
  //   this.isSelected =true ;
  // }

  ngOnInit() {
    this.getALLquestionsTypes() ;
  }



}
