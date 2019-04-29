import {Component, OnInit} from '@angular/core';
import {QuestionVto} from "../../../../../shared/data/quiz/question-vto";
import {QuizService} from "../../../../../shared/services/quiz.service";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
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
  //studentID: number =1 ;
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
    questions: new FormArray([]),
  });


  private  get questions(): FormArray {
    return this.formData.get('questions') as FormArray;
  }

  private addItem(answer:string): void {
    this.questions.push(this.formBuilder.group({
      questionID :null ,
      studentAnswer:null ,
    }));
  }


  clearFormArray = (formArray: FormArray) => {
    while (formArray.length !== 0) {
      formArray.removeAt(0)
    }
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


    this.quizService.submitQuizAnswersForStudent(this.quizID,this.studentAnswers).subscribe(res => {
      console.log("Success");``
    }, err => {
      console.log(err);
    } );
  }

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



