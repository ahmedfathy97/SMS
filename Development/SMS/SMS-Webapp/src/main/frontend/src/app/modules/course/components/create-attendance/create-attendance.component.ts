import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseVto} from "../../shared/data/course-vto.data";
import {CourseService} from "../../shared/services/course.service";
import {AttendanceDTO} from "../../shared/data/attendance-dto.data";
import {AttendanceService} from "../../shared/services/attendance.service";

@Component({
  selector: 'app-create-attendance',
  templateUrl: './create-attendance.component.html',
  providers: [FormBuilder, CourseService ,AttendanceService],
})
export class CreateAttendanceComponent implements OnInit {

  //TODO: Yara - no need for this remove it


  formData = this.formBuilder.group({
    //TODO: Yara - rename formControlName to courseID remember change in HTML
    courseID: ['', Validators.required],
    //TODO: Yara - rename formControlName to attendanceDate remember change in HTML
    attendanceDate: ['', Validators.required]
  });
  //TODO: Yara - rename to courses remember change in HTML
  courses: CourseVto [] = [];

  //TODO: Yara - rename to attendance remember change in HTML
  attendance: AttendanceDTO = new AttendanceDTO();

  constructor(private formBuilder: FormBuilder, private  courseService: CourseService , private  attendanceService: AttendanceService) {
  }

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
        this.attendance.students = res;
        console.log(this.attendance.students);

      }
    );
  }

  //TODO: Yara - rename to onSubmitNewAttendance
  onSubmitNewAttendance() {

    let data: AttendanceDTO = new AttendanceDTO();
    data.course_id = this.formData.get('courseID').value;
    data.attendanceData = this.formData.get('attendanceDate').value;
    data.students = this.attendance.students;


    console.log(data);
    this.attendanceService.createNewAttendanceSheet(2 ,data).subscribe(
      res => {
        console.log('request succed')
      },
      error1 => {
        console.log(error1)
      }
    );

  };

  //TODO: Yara - rename to toggleStdAttendance
  toggleStdAttendance(index) {
    this.attendance.students[index].isAttend = !this.attendance.students[index].isAttend;
    console.log(this.attendance.students);
  }
}
