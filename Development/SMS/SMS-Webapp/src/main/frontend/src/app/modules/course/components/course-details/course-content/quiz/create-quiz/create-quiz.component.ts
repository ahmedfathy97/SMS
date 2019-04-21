import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

import {ActivatedRoute, Router} from "@angular/router";
import {CourseService} from "../../../../../shared/services/course.service";
import {QuizDto} from "../../../../../shared/data/quiz/quiz-dto";
import {CourseDataService} from "../../../../../shared/services/course-data.service";

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss'],
  providers: [FormBuilder, CourseService]
})
export class CreateQuizComponent implements OnInit {
  corID :number ;
  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private courseService: CourseService,private corDataService: CourseDataService) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        //this.onSubmitNewQuiz()
      }
    );
    this.corDataService.requestCorID.next(true);

  }

  ngOnInit() {
  }

  formData: FormGroup = this.formBuilder.group({
    quizName: [null, [Validators.required, Validators.maxLength(25)]],
    quizGrade: [null, [Validators.required]],
    startDate: [null, [Validators.required]],
    finishDate: [null, [Validators.required]]
  });

  onSubmitNewQuiz() {
    let quizData: QuizDto = new QuizDto();
    quizData.quizName = this.formData.get('quizName').value;
    quizData.grade = this.formData.get('quizGrade').value;
    quizData.startDate = this.formData.get('startDate').value;
    quizData.finishDate = this.formData.get('finishDate').value;
    quizData.isClosed = false;
    console.log(quizData);
    this.courseService.createNewQuiz(this.corID, quizData).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });




  }

}
