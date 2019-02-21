import { Component, OnInit } from '@angular/core';
import {StdDTO} from "../../shared/data/std-dto.data";
import {CourseService} from "../../shared/services/course.service";
//import {AttendanceService} from "../../shared/services/attendance.service";

@Component({
  selector: 'app-view-student-attendance',
  templateUrl: './view-student-attendance.component.html',
  styleUrls: ['./view-student-attendance.component.scss'],
  providers:[CourseService]
})
export class ViewStudentAttendanceComponent implements OnInit {

  attendanceList :StdDTO [] = [];
  constructor( private attendanceService : CourseService ) { }

  ngOnInit() {
    this.attendanceService.getStudentAttendance(2 , 1).subscribe(
      res => this.attendanceList = res
    )
  }

}
