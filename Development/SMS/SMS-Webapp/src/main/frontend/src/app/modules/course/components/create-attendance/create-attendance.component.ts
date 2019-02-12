import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseType} from "../../shared/data/course-type-dto.data";
import {CourseService} from "../../shared/course.service";
import {StdDto} from "../../shared/data/std-dto.data";
import {AttendData} from "../../shared/data/attend-dto.data";

@Component({
  selector: 'app-create-attendance',
  templateUrl: './create-attendance.component.html',
  styleUrls: ['./create-attendance.component.scss'],
  providers : [FormBuilder , CourseService],
})
export class CreateAttendanceComponent implements OnInit {

  dataList : StdDto []=[] ;

  formData= this.formBuilder.group({

    course: ['', Validators.required],
    date : ['', Validators.required]
  });

  constructor(private formBuilder : FormBuilder ,private  courseService: CourseService) { }
  corTypes: CourseType [] = [];
  // std: StdDto ;
attendence: AttendData = new AttendData();
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
        this.attendence.stdList=res;
        console.log(this.attendence.stdList);

      }
    );}
  saveAttend(){

      let data: AttendData = new AttendData();
      data.course_id = this.formData.get('course').value;
      data.date = this.formData.get('date').value;
      data.stdList = this.attendence.stdList;


    console.log(data);
      this.courseService.saveAttendData(data).subscribe(
        res => {
          console.log('request succed')
        },
        error1 => {
          console.log(error1)
        }
      );

    };


  toggleEditable(index) {
    // if ( event.target.checked ) {
      this.attendence.stdList[index].isAttend = !this.attendence.stdList[index].isAttend;
    // }
    console.log(this.attendence.stdList);
  }
}
