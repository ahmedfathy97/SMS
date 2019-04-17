import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

import {ActivatedRoute, Router} from "@angular/router";
import {CourseService} from "../../../../../shared/services/course.service";
import {QuizDto} from "../../../../../shared/data/quiz/quiz-dto";

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss'],
  providers: [FormBuilder, CourseService]
})
export class CreateQuizComponent implements OnInit {
  courseID: string;
  corID :number ;
  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService, private route: ActivatedRoute ,
              ) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
    })


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
    //quizData.courseID = 1;
    quizData.startDate = this.formData.get('startDate').value;
    quizData.finishDate = this.formData.get('finishDate').value;
    quizData.isClosed = false;
    var courseID = +this.courseID;
    this.corID = courseID ;
    this.courseService.createNewQuiz(this.corID, quizData).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });




  }

}
