import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseType} from "../../shared/data/course-type-dto.data";
import {CourseService} from "../../shared/course.service";

@Component({
  selector: 'app-create-attendance',
  templateUrl: './create-attendance.component.html',
  styleUrls: ['./create-attendance.component.scss'],
  providers : [FormBuilder , CourseService],
})
export class CreateAttendanceComponent implements OnInit {

  formData= this.formBuilder.group({

    course: ['', Validators.required],
    date : ['', Validators.required]
  });

  constructor(private formBuilder : FormBuilder ,private  courseService: CourseService) { }
  corTypes: CourseType [] = [];

  ngOnInit() {


    this.courseService.findCourseType().subscribe(
      res => {
        this.corTypes = res;
        console.log(this.corTypes);
      }
    );
  }

}
