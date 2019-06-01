import {Component, OnInit} from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {CourseQuizesVto} from "../../../../../shared/data/quiz/course-quizes-vto";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AngularFullRoutes ,replaceCorID ,replaceQuizID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";

@Component({
  selector: 'app-course-quizes',
  templateUrl: './course-quizes.component.html',
  styleUrls: ['./course-quizes.component.scss'],
  providers: [CourseService]

})
export class CourseQuizesComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  replaceQuizID =replaceQuizID;
  alert: AlertInput = new AlertInput();

  corID: number ;
  quizList:CourseQuizesVto[] ;
  constructor(private courseService: CourseService,
              private corDataService: CourseDataService,
              private route: ActivatedRoute ) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseQuizes();
      }
    );
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {

  }

  getCourseQuizes(){
    this.courseService.getCourseQuizes(this.corID).subscribe(res => {
      this.quizList = res;
      this.alert = new SuccessAlert();
    }, err => {
      this.alert = new FailureAlert(err);
      console.log(err);
    });
  }

}
