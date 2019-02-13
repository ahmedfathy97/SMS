import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseType} from "../../shared/data/course-type-dto.data";
import {CourseService} from "../../shared/course.service";
import {StdDto} from "../../shared/data/std-dto.data";
import {AttendData} from "../../shared/data/attend-dto.data";

@Component({
  selector: 'app-create-attendance',
  templateUrl: './create-attendance.component.html',
  providers: [FormBuilder, CourseService],
})
export class CreateAttendanceComponent implements OnInit {

  //TODO: Yara - no need for this remove it
  dataList: StdDto [] = [];

  formData = this.formBuilder.group({
    //TODO: Yara - rename formControlName to courseID remember change in HTML
    course: ['', Validators.required],
    //TODO: Yara - rename formControlName to attendanceDate remember change in HTML
    date: ['', Validators.required]
  });
  //TODO: Yara - rename to courses remember change in HTML
  corTypes: CourseType [] = [];

  //TODO: Yara - rename to attendance remember change in HTML
  attendence: AttendData = new AttendData();

  constructor(private formBuilder: FormBuilder, private  courseService: CourseService) {
  }

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
        this.attendence.stdList = res;
        console.log(this.attendence.stdList);

      }
    );
  }

  //TODO: Youssef - rename to onSubmitNewAttendance
  saveAttend() {

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

  //TODO: Yara - rename to toggleStdAttendance
  toggleEditable(index) {
    this.attendence.stdList[index].isAttend = !this.attendence.stdList[index].isAttend;
    console.log(this.attendence.stdList);
  }
}
