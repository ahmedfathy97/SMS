import {Component, OnInit} from '@angular/core';
import {QuestionVto} from "../../../../../shared/data/quiz/question-vto";
import {QuizService} from "../../../../../shared/services/quiz.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {StudentAnswerDto} from "../../../../../shared/data/quiz/student-answer-dto";
import {ActivatedRoute} from "@angular/router";
import {
  AngularFullRoutes,
  replaceCorID,
  replaceQuizID
} from "../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../shared/services/course-data.service";

@Component({
  selector: 'app-answer-questions',
  templateUrl: './answer-questions.component.html',
  styleUrls: ['./answer-questions.component.scss'],
  providers: [QuizService ,FormBuilder]
})
export class AnswerQuestionsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  studentID: number =1 ;
  corID :number ;
  quizID:number ;
  quizQuestions: QuestionVto[] =[];
  studentAnswers:StudentAnswerDto[] =[] ;

  constructor(private formBuilder: FormBuilder ,
              private quizService: QuizService ,private route: ActivatedRoute ,private corDataService: CourseDataService) {
    this.route.paramMap.subscribe(params => {
      this.quizID = +params.get("quizID");
    })

    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
      }
    );
    this.corDataService.requestCorID.next(true);

  }




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
     //var quizID = +this.quizID ;

    for(let question of this.quizQuestions)
    {
      studentAnswer.questionID =question.id ;
      studentAnswer.studentAnswer= this.formData.get('studentAnswer').value ;
      this.studentAnswers.push(studentAnswer);
    }

    this.quizService.submitQuizAnswersForStudent(this.studentID ,this.quizID,this.studentAnswers).subscribe(res => {
      console.log("Success");``
    }, err => {
      console.log(err);
    } );
  }

  ngOnInit() {
    this.getQuizQuestions();
  }

}



