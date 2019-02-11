import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseDetailsData} from "../../../shared/data/course/course-details.data";
import {CourseService} from "../../../shared/course.service";

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css'],
  providers:  [CourseService]
})
export class CourseDetailsComponent implements OnInit {

  constructor(private formBuilder : FormBuilder,
              private service : CourseService) { }

  ngOnInit() {
  }
formData : FormGroup = this.formBuilder.group({
      courseName : [null, [Validators.required, Validators.maxLength(25)]],
      duration : [null, [Validators.required, Validators.min(1)]],
      startDate : [null , [Validators.required]],
      endDate : [null,[Validators.required]],
      categoryID : [null , Validators.required],
      typeID : [null , Validators.required],
      levelID : [null , Validators.required],
      description : [null , [Validators.maxLength(200)]],
})
addCourseData(){
    let  details : CourseDetailsData = new CourseDetailsData();

  details.courseName = this.formData.get('courseName').value;
  details.duration = this.formData.get('duration').value;
  details.startDate = this.formData.get('startDate').value;
  details.endDate = this.formData.get('endDate').value;
  details.categoryID = this.formData.get('categoryID').value;
  details.typeID = this.formData.get('typeID').value;
  details.levelID = this.formData.get('levelID').value;
  details.description = this.formData.get('description').value;

  this.service.addCourseData(details).subscribe( res => {console.log("Success");}, err => {console.log(err);});

              }

}
