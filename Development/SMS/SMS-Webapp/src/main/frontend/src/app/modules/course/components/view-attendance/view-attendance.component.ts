import { Component, OnInit } from '@angular/core';
import {AttendanceService} from "../../shared/services/attendance.service";
import {CourseService} from "../../shared/services/course.service";
import {StdDTO} from "../../shared/data/std-dto.data";

@Component({
  selector: 'app-view-attendance',
  templateUrl: './view-attendance.component.html',
  providers : [CourseService]
})
export class ViewAttendanceComponent implements OnInit {

  attendanceList :StdDTO [] = [];
  constructor( private attendanceService : CourseService ) { }

  ngOnInit() {
    this.attendanceService.getCourseAttendance (2).subscribe(
    res => this.attendanceList = res
    )
  }

}
