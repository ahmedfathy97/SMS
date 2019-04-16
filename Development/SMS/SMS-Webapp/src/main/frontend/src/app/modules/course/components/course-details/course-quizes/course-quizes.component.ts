import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../shared/services/course.service";
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {CourseQuizesVto} from "../../../shared/data/quiz/course-quizes-vto";

@Component({
  selector: 'app-course-quizes',
  templateUrl: './course-quizes.component.html',
  styleUrls: ['./course-quizes.component.scss'] ,
  providers: [CourseService]

})
export class CourseQuizesComponent implements OnInit {
  courseID: string;
  corID: number ;
  quizList:CourseQuizesVto[] ;
  constructor(private courseService: CourseService, private route: ActivatedRoute ) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
    })
  }

  ngOnInit() {
    var courseID  = +this.courseID ;
    this.corID =courseID ;
    this.courseService.getCourseQuizes(this.corID).subscribe(res => {
      console.log("Success");
      this.quizList= res ;
    }, err => {
      console.log(err);
    });


  }

}
