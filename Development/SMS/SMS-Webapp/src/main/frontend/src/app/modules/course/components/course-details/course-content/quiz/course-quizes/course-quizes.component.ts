import {Component, OnInit} from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {CourseQuizesVto} from "../../../../../shared/data/quiz/course-quizes-vto";
import {CourseDataService} from "../../../../../shared/services/course-data.service";

@Component({
  selector: 'app-course-quizes',
  templateUrl: './course-quizes.component.html',
  styleUrls: ['./course-quizes.component.scss'],
  providers: [CourseService]

})
export class CourseQuizesComponent implements OnInit {
  // courseID: string;
  corID: number ;
  quizList:CourseQuizesVto[] ;
  constructor(private courseService: CourseService,
              private corDataService: CourseDataService,
              private route: ActivatedRoute ) {
    // this.route.paramMap.subscribe(params => {
    //   this.corID = +params.get("courseID");
    // })
    this.corDataService.corID.subscribe(
      data =>{
        debugger ;
        this.corID = data;
        console.log(data);
      }
    );
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {
    debugger;
    // var courseID = +this.courseID;
    // this.corID = courseID;
    this.courseService.getCourseQuizes(this.corID).subscribe(res => {
      console.log("Success");
      debugger;
      this.quizList = res;
    }, err => {
      console.log(err);
    });


  }

}
