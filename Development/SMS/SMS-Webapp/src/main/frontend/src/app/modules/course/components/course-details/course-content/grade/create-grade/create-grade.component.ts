import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {GradeService} from "../../../../../shared/services/grade.service";
import {CourseVto} from "../../../../../shared/data/course-vto";
import {StdDTO} from "../../../../../shared/data/std-dto.data";
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../../../../shared/services/course-data.service";


@Component({
  selector: 'app-create-grade',
  templateUrl: './create-grade.component.html',
  styleUrls: ['./create-grade.component.scss'],
  providers: [FormBuilder,CourseService ,GradeService]
})
export class CreateGradeComponent implements OnInit {

  corID :number ;
  formData: FormGroup = this.formBuilder.group({
    course: [null, [Validators.required]],
    items: new FormArray([])
  });

  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService,
              private corDataService: CourseDataService,
              private gradeService:GradeService , private route: ActivatedRoute) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        this.getCourseStudents();


  });
    this.corDataService.requestCorID.next(true);
  }
  getCourseStudents(){
    this.courseService.getAllCourseStudents(this.corID).subscribe(
      res => {
        this.students = res;
        this.clearFormArray(this.items);
        for(let i=0; i<this.students.length; i++)
          this.addItem();
        // this.courseSelected=true;


      }
    )

  }
  // courses: CourseVto [] = [];
  // courseSelected:boolean=false;

  students: StdDTO[] = [];

  ngOnInit() {
    // var courseID = +this.courseID;
    // this.corID = courseID ;
    // this.courseService.getAllInstructorCourses().subscribe(
    //   res => {
    //     this.courses = res;
    //     console.log(this.courses);
    //   }
    // );
    // debugger;



  }

  // onChangeCourse(courseID) {
  //   console.log(courseID);
  //
  //
  // }

  onSubmitGradeSheet() {

    for(let i=0; i<this.students.length; i++)
      this.students[i].midTermOne = this.items.at(i).get('midTermOne').value;

    console.log(this.students);
    this.gradeService.createNewGradeSheet(this.corID,this.students).subscribe(
      res=> {
        console.log('request succed')
      },
      error1 => {
        console.log(error1)
      }
    );


  }

  private get items(): FormArray {
    return this.formData.get('items') as FormArray;
  }

  private addItem(): void {
    this.items.push(this.createItem());
    // this.formData.reset();
  }
  private createItem(): FormGroup {
    return this.formBuilder.group({
      midTermOne: null,
      semiFinal: null,
      midTermTwo: null,
      final: null,

    });
  }
  clearFormArray = (formArray: FormArray) => {
    while (formArray.length !== 0) {
      formArray.removeAt(0)
    }
  }
}





