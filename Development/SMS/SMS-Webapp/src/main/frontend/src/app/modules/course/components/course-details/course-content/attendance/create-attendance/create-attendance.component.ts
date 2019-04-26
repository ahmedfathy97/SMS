import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {AttendanceDTO} from "../../../../../shared/data/attendance-dto.data";
import {AttendanceService} from "../../../../../shared/services/attendance.service";
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-create-attendance',
  templateUrl: './create-attendance.component.html',
  providers: [FormBuilder, CourseService ,AttendanceService],
})
export class CreateAttendanceComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  // courseID: string;
  corID :number ;
  formData = this.formBuilder.group({
    attendanceDate: ['', Validators.required]
  });

  attendance: AttendanceDTO = new AttendanceDTO();

  constructor(private formBuilder: FormBuilder, private  courseService: CourseService ,
              private  attendanceService: AttendanceService ,
              private corDataService: CourseDataService,
              private route: ActivatedRoute) {


    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        this.getCourseStudents() ;
      }
    );
    this.corDataService.requestCorID.next(true);
  }

  getCourseStudents()
  {
    this.courseService.getAllCourseStudents(this.corID, null,
      this.formData.get('attendanceDate').value).subscribe(
      res => {
        this.attendance.students = res;
        console.log(this.attendance.students);

      }
    );
  }

  ngOnInit() {

  }



  exist : boolean = false ;

  onSubmitNewAttendance() {
    let data: AttendanceDTO = new AttendanceDTO();
    data.attendanceData = this.formData.get('attendanceDate').value;
    data.students = this.attendance.students;
    console.log(data);
      this.attendanceService.createNewAttendanceSheet(this.corID, data).subscribe(
        res => {
          console.log('request succed')
        },
        error1 => {
          console.log(error1)
        }
      );
      this.exist = true ;
  };


  toggleStdAttendance(index) {
    this.attendance.students[index].isAttend = !this.attendance.students[index].isAttend;
    console.log(this.attendance.students);
  }
}
