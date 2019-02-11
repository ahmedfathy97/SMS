import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../shared/course.service";
import {StdDto} from "../../shared/data/std-dto.data";
import {CourseType} from "../../shared/data/course-type-dto.data";

@Component({
  selector: 'app-create-grade',
  templateUrl: './create-grade.component.html',
  styleUrls: ['./create-grade.component.scss'],
  providers: [FormBuilder,CourseService]
})
export class CreateGradeComponent implements OnInit {
  formData:FormGroup = this.formBuilder.group({
    stdName:[  '' , [Validators.required,Validators.maxLength(15)]],
    midTermOne:[  '' , [Validators.required]],
    semiFinal:[  '' , [Validators.required]],
    midTermTwo:[  '' , [Validators.required]],
    Final:[  '' , [Validators.required]],
    course:[  null , [Validators.required]]
  });

  constructor(private formBuilder: FormBuilder,private courseService:CourseService) {
    // this.formData.get('course').valueChanges.subscribe(
    //   (courseID : number) => {
    //     console.log(courseID);
    //     this.courseService.findStdName(courseID).subscribe(
    //       res=>{
    //         this.stdDto=res;
    //         console.log(this.stdDto);
    //
    //       }
    //     );
    //   }
    // );

  }
  corTypes: CourseType [] = [];

  stdDto: StdDto[]=[];
  ngOnInit() {
    this.courseService.findCourseType().subscribe(
      res => {
        this.corTypes = res;
        console.log(this.corTypes);
      }
    );


  }
  onChangeCourse(courseID){
    console.log(courseID);
    this.courseService.findStdName(courseID).subscribe(
    res=>{
      this.stdDto=res;
      console.log(this.stdDto);

    }
  );}
}
