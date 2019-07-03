import {Component, OnInit} from '@angular/core';
import {QuestionVto} from "../../../../../../shared/data/quiz/question-vto";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StudentAnswerDto} from "../../../../../../shared/data/quiz/student-answer-dto";
import {ActivatedRoute} from "@angular/router";
import {
  AngularFullRoutes,
  replaceCorID,
  replaceQuizID
} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {FailureAlert} from "../../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {SuccessAlert} from "../../../../../../../../infrastructure/components/alerts/success-alert.data";
import {AlertInput} from "../../../../../../../../infrastructure/components/alerts/alert-input";
import {AuthActions} from "../../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {CourseService} from "../../../../../../shared/services/course.service";

@Component({
  selector: 'app-answer-questions',
  templateUrl: './answer-questions.component.html',
  styleUrls: ['./answer-questions.component.scss'],
  providers: [QuizService ,FormBuilder, CourseService]
})
export class AnswerQuestionsComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  //studentID: number =1 ;
  corID :number ;
  quizID:number ;
  quizQuestions: QuestionVto[] =[];
  studentAnswers:StudentAnswerDto[] =[] ;
  alert: AlertInput = new AlertInput();
  constructor(private formBuilder: FormBuilder ,
              private courseService: CourseService,
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

  private addItem(questionID:number): void {
    this.questions.push(this.formBuilder.group({
      questionID : questionID ,
      studentAnswer: null ,
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
    for(let i=0; i<this.quizQuestions.length; i++)
    {
      studentAnswer.questionID =this.quizQuestions[i].id ;
      studentAnswer.studentAnswer= this.questions.at(i).get('studentAnswer').value;
      this.studentAnswers.push(studentAnswer);
    }

    this.quizService.submitQuizAnswersForStudent(this.quizID,this.studentAnswers).subscribe(res => {
      console.log("Success");
      this.alert = new SuccessAlert();
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    } );
  }

  getQuizQuestions() {
    this.quizService.getQuizQuestions(this.quizID).subscribe(res => {
      console.log("Success");
      this.quizQuestions = res;
      this.clearFormArray(this.questions) ;

      for(let question of this.quizQuestions)
      {
          this.addItem(question.id) ;
      }
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
    this.getQuizQuestions();
  }

}



