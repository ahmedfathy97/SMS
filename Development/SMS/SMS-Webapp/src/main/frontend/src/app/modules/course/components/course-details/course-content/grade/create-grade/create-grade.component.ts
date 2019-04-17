import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {GradeService} from "../../../../../shared/services/grade.service";
import {CourseVto} from "../../../../../shared/data/course-vto";
import {StdDTO} from "../../../../../shared/data/std-dto.data";


@Component({
  selector: 'app-create-grade',
  templateUrl: './create-grade.component.html',
  styleUrls: ['./create-grade.component.scss'],
  providers: [FormBuilder,CourseService ,GradeService]
})
export class CreateGradeComponent implements OnInit {
  formData: FormGroup = this.formBuilder.group({
    course: [null, [Validators.required]],
    items: new FormArray([])
  });

  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService,
              private gradeService:GradeService ) {

  }

  courses: CourseVto [] = [];
  courseSelected:boolean=false;

  students: StdDTO[] = [];

  ngOnInit() {
    this.courseService.getAllInstructorCourses().subscribe(
      res => {
        this.courses = res;
        console.log(this.courses);
      }
    );


  }

  onChangeCourse(courseID) {
    console.log(courseID);

    this.courseService.getAllCourseStudents(courseID).subscribe(
      res => {
        this.students = res;
        this.clearFormArray(this.items);
        for(let i=0; i<this.students.length; i++)
          this.addItem();
        this.courseSelected=true;


      }
    );
  }

  onSubmitGradeSheet() {

    for(let i=0; i<this.students.length; i++)
      this.students[i].midTermOne = this.items.at(i).get('midTermOne').value;

    console.log(this.students);
    this.gradeService.createNewGradeSheet(2,this.students).subscribe(
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





