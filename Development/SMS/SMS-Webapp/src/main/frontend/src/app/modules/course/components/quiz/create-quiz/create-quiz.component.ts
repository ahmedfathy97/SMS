import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuizDto} from "../../../shared/data/quiz/quiz-dto";
import {QuizService} from "../../../shared/services/quiz.service";
import {CourseService} from "../../../shared/services/course.service";

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss'] ,
  providers:[FormBuilder ,CourseService]
})
export class CreateQuizComponent implements OnInit {
  courseID: number = 1;
  constructor(private formBuilder: FormBuilder ,
              private courseService :CourseService) { }

  ngOnInit() {
  }

  formData: FormGroup = this.formBuilder.group({
    quizName :[null, [Validators.required, Validators.maxLength(25)]],
    quizGrade:[null,[Validators.required] ],
    dueDate:[null ,[Validators.required] ]
  }) ;

  onSubmitNewQuiz()
  {
    let quizData : QuizDto = new QuizDto() ;
    quizData.quizName =this.formData.get('quizName').value;
    quizData.grade =this.formData.get('quizGrade').value;
    //quizData.courseID = 1;
    quizData.dueDate =this.formData.get('dueDate').value ;

    this.courseService.createNewQuiz(this.courseID, quizData).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }

}
