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
  questionData :  QuestionDto ;
  questionsList: QuestionDto[] =[];
  textualIsSelected:boolean =false ;
  mcqIsSelected:boolean =false ;
  trueFalseIsSelsected:boolean=false ;
  table:boolean =false ;
  quizid: number =1;

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
    questiontype:null ,
    question:null ,
    modelAnswer:null ,
    answer1:null ,
    answer2:null ,
    answer3:null ,
    answer4:null
  }) ;


 onclickAddQuestion() {
   let questionData :QuestionDto =new QuestionDto()
   questionData.questionTypeID=this.formData.get('questiontype').value ;
   questionData.question =this.formData.get('question').value;
   questionData.modelAnswer =this.formData.get('modelAnswer').value;
   questionData.answer1 =this.formData.get('answer1').value ;
   questionData.answer2 =this.formData.get('answer2').value ;
   questionData.answer3 =this.formData.get('answer3').value ;
   questionData.answer4 =this.formData.get('answer3').value ;
   this.questionsList.push(questionData) ;
   this.table =true ;
   this.formData.reset();
 }

  onSubmitQuestionsTable()
  {
    this.quizService.createQuizQuestions(this.quizid ,this.questionsList).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err)
    });

  }

  onclickoption(event:any)
  {
    debugger ;
    console.log(event) ;
    if (event==1)
    {
      this.mcqIsSelected =true ;
      this.trueFalseIsSelsected =false ;
      this.textualIsSelected =false ;

    }else if( event ==2)
    {
      this.trueFalseIsSelsected =true ;
      this.mcqIsSelected =false ;
      this.textualIsSelected =false ;


    }else if(event ==3)
    {
      this.textualIsSelected =true ;
      this.trueFalseIsSelsected =false  ;
      this.mcqIsSelected =false ;

    }else {

    }

  }


  ngOnInit() {
    this.getALLquestionsTypes() ;
  }

}