import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {QuizService} from "../../../../../../shared/services/quiz.service";
import {QuestionVto} from "../../../../../../shared/data/quiz/question-vto";
import {AlertInput} from "../../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../../infrastructure/components/alerts/success-alert.data";
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {StudentAnswerDto} from "../../../../../../shared/data/quiz/student-answer-dto";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {FailureAlert} from "../../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {ExamServices} from "../../../../../../shared/services/exam.services";

@Component({
  selector: 'app-answer-exam-questions',
  templateUrl: './answer-exam-questions.component.html',
  styleUrls: ['./answer-exam-questions.component.css'] ,
  providers:[ExamServices]
})
export class AnswerExamQuestionsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  //studentID: number =1 ;
  corID :number ;
  examID:number ;
  exanQuestions: QuestionVto[] =[];
  studentAnswers:StudentAnswerDto[] =[] ;
  alert: AlertInput = new AlertInput();
  constructor(private formBuilder: FormBuilder ,private router: Router,
              private examService: ExamServices ,private route: ActivatedRoute ,private corDataService: CourseDataService) {
    this.route.paramMap.subscribe(params => {
      this.examID = +params.get("examID");
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
    for(let i=0; i<this.exanQuestions.length; i++)
    {
      studentAnswer.questionID =this.exanQuestions[i].id ;
      studentAnswer.studentAnswer= this.questions.at(i).get('studentAnswer').value;
      this.studentAnswers.push(studentAnswer);
    }


    this.examService.submitExamAnswersForStudent(this.examID,this.studentAnswers).subscribe(res => {
      this.router.navigate([replaceCorID(this.ROUTES.COR_VIEW_EXAM, this.corID)])
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    } );
  }

  getQuizQuestions() {
    this.examService.getExamQuestions(this.examID).subscribe(res => {
      console.log("Success");
      this.exanQuestions = res;
      // this.alert = new SuccessAlert();
      this.clearFormArray(this.questions) ;

      for(let question of this.exanQuestions)
      {
        this.addItem(question.id) ;
      }
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }

  ngOnInit() {
    this.getQuizQuestions();
  }

}
