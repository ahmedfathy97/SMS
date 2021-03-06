import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CourseService} from "../../../../../shared/services/course.service";
import {QuizDto} from "../../../../../shared/data/quiz/quiz-dto";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {LocalStorageService} from "../../../../../../../infrastructure/services/local-storage.service";
import {AuthUserVTO} from "../../../../../../security/shared/data/auth-user-vto.data";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";


@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss'],
  providers: [FormBuilder, CourseService]
})
export class CreateQuizComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID :number ;
  currentUser: AuthUserVTO;
  alert: AlertInput = new AlertInput();
  constructor(private formBuilder: FormBuilder,
              private router: Router, private localStorageSerice: LocalStorageService,
              private courseService: CourseService,private corDataService: CourseDataService) {
    this.currentUser = this.localStorageSerice.getCurrentUser();
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
      }
    );
    this.corDataService.requestCorID.next(true);

  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
  }

  formData: FormGroup = this.formBuilder.group({
    quizName: [null, [Validators.required, Validators.maxLength(10)]],
    quizGrade: [null, [Validators.required ,Validators.min(1)]],
    startDate: [null, [Validators.required]],
    finishDate: [null, [Validators.required]]
  });
  get form() { return this.formData.controls; }
  onSubmitNewQuiz() {
    let quizData: QuizDto = new QuizDto();
    quizData.quizName = this.formData.get('quizName').value;
    quizData.grade = this.formData.get('quizGrade').value;
    quizData.startDate = this.formData.get('startDate').value;
    quizData.finishDate = this.formData.get('finishDate').value;
    quizData.isClosed = false;
    console.log(quizData);
    this.courseService.createNewQuiz(this.corID, quizData).subscribe(res => {
      let quizID:number = res;
      this.router.navigate([`/course/${this.corID}/quiz/${quizID}/questions`]) ;
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });




  }

}
