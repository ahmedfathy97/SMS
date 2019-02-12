import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../shared/course.service";
import {StdDto} from "../../shared/data/std-dto.data";
import {CourseType} from "../../shared/data/course-type-dto.data";
import {CourseGrd} from "../../shared/data/course-grd-dto.data";

@Component({
  selector: 'app-create-grade',
  templateUrl: './create-grade.component.html',
  styleUrls: ['./create-grade.component.scss'],
  providers: [FormBuilder,CourseService ]
})
export class CreateGradeComponent implements OnInit {
  formData: FormGroup = this.formBuilder.group({
    stdName: ['', [Validators.required, Validators.maxLength(15)]],
    // midTermOne: ['', [Validators.required]],
    // semiFinal: ['', [Validators.required]],
    // midTermTwo: ['', [Validators.required]],
    // Final: ['', [Validators.required]],
    course: [null, [Validators.required]],

    items: new FormArray([])
  });
  // items: FormArray;

  constructor(private formBuilder: FormBuilder, private courseService: CourseService) {
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

  stdDto: StdDto[] = [];

  ngOnInit() {
    this.courseService.findCourseType().subscribe(
      res => {
        this.corTypes = res;
        console.log(this.corTypes);
      }
    );


  }

  onChangeCourse(courseID) {
    console.log(courseID);
    this.courseService.findStdName(courseID).subscribe(
      res => {
        this.stdDto = res;
        for(let i=0; i<this.stdDto.length; i++)
          this.addItem();

      }
    );
  }

  saveStdGrades() {
    let data: CourseGrd = new CourseGrd();
    data.corId = this.formData.get('course').value;
    data.students = this.stdDto;
    for(let i=0; i<data.students.length; i++)
      data.students[i].midTermOne = this.items.at(i).get('midTermOne').value;

    console.log(data);
    this.courseService.saveStdGrades(data).subscribe(
      res=> {
        console.log('request succed')
      },
      error1 => {
        console.log(error1)
      }
    );


  }

  get items(): FormArray {
    return this.formData.get('items') as FormArray;
  }
  addItem(): void {
    // this.items = this.formData.get('items') as FormArray;
    this.items.push(this.createItem());
  }
  createItem(): FormGroup {
    return this.formBuilder.group({
      midTermOne: null,
      semiFinal: null,
      midTermTwo: null,
      Final: null
    });
  }
}





