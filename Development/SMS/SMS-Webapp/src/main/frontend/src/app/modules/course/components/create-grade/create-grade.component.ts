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
    //TODO: Hala - remove this as there is no need for it
    stdName: ['', [Validators.required, Validators.maxLength(15)]],
    course: [null, [Validators.required]],
    items: new FormArray([])
  });

  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService) {

  }

  //TODO: Hala - rename to courses remember change in HTML
  corTypes: CourseType [] = [];

  //TODO: Hala - rename to students remember change in HTML
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

  //TODO: Hala - rename to onSubmitGradeSheet remember change in HTML
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

  private get items(): FormArray {
    return this.formData.get('items') as FormArray;
  }
  private addItem(): void {
    this.items.push(this.createItem());
  }
  private createItem(): FormGroup {
    return this.formBuilder.group({
      midTermOne: null,
      semiFinal: null,
      midTermTwo: null,
      Final: null
    });
  }
}





