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
  questionsList: QuestionDto[] =[];
  textualIsSelected:boolean =false ;
  mcqIsSelected:boolean =false ;
  trueFalseIsSelsected:boolean=false ;
  table:boolean =false ;
  quizid: number =1;
  editMode:boolean =false ;
  msqAnswer :any[] ;
  //questionData :QuestionDto ;



  getALLquestionsTypes()
  {
    this.quizService.getAllQuestionsTypes().subscribe(res => {
      console.log("Success");
      this.questionTypeList =res ;
    }, err => {
      console.log(err);
    });
  }


  onclickoption(event:any)
  {
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
   debugger ;
   questionData.questionTypeID=this.formData.get('questiontype').value ;
   questionData.question =this.formData.get('question').value;
   questionData.modelAnswer =this.formData.get('modelAnswer').value;
   questionData.answer1 =this.formData.get('answer1').value ;
   questionData.answer2 =this.formData.get('answer2').value ;
   questionData.answer3 =this.formData.get('answer3').value ;
   questionData.answer4 =this.formData.get('answer4').value ;
   this.questionsList.push(questionData) ;
   this.table =true ;
   this.formData.reset();
 }


 // test(event)
 // {
 //   debugger ;
 //   if(event.target.checked)
 //   {
 //     console.log(event.target.) ;
 //   }
 // }

  onSubmitQuestionsTable()
  {
    this.quizService.createQuizQuestions(this.quizid ,this.questionsList).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err)
    });
  }


  editQuestion(index)
  {
    this.formData.get('questiontype').reset(this.questionsList[index].questionTypeID) ;
    this.formData.get('question').reset(this.questionsList[index].question) ;
    this.formData.get('modelAnswer').reset(this.questionsList[index].modelAnswer) ;
    this.formData.get('answer1').reset(this.questionsList[index].answer1) ;
    this.formData.get('answer2').reset(this.questionsList[index].answer2) ;
    this.formData.get('answer3').reset(this.questionsList[index].answer3) ;
    this.formData.get('answer4').reset(this.questionsList[index].answer4);
    this.questionsList.splice(index ,1) ;
    this.editMode = true ;
  }


  deleteQuestion(index)
  {
    this.questionsList.splice(index ,1);
  }


  // onselectTrueFalseAnswer(questionData:QuestionDto)
  // {
  //   questionData.modelAnswer =
  // }

  // onSelectChoise(event:any)
  // {
  //
  //     this.questionData.modelAnswer = event.target.checked ;
  //
  // }

  ngOnInit() {
    this.getALLquestionsTypes() ;
  }

}
