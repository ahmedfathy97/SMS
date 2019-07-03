import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {AttendanceDTO} from "../../../../../shared/data/attendance-dto.data";
import {AttendanceService} from "../../../../../shared/services/attendance.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {LocalStorageService} from "../../../../../../../infrastructure/services/local-storage.service";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";

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

  form(){return this.formData.controls;}
  alert: AlertInput = new AlertInput();

  attendance: AttendanceDTO = new AttendanceDTO();

  constructor(private formBuilder: FormBuilder, private  courseService: CourseService ,
              private router: Router, private localStorageSerice: LocalStorageService,
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

  isUpdated: boolean = false;
  getCourseStudents()
  {
    this.courseService.getAllCourseStudents(this.corID, null,
      this.formData.get('attendanceDate').value).subscribe(
      res => {
        if(res.length == 0) {
          this.courseService.getAllCourseStudents(this.corID, null, null).subscribe(
            res => {
              this.attendance.students = res
            }
          );
          this.isUpdated = false;
        } else {
          this.isUpdated = true;
          this.attendance.students = res;
        }
      }
    );
  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
  }



  //isUpdate : boolean = false ;

  onSubmitNewAttendance() {
    let data: AttendanceDTO = new AttendanceDTO();
    data.attendanceData = this.formData.get('attendanceDate').value;
    data.students = this.attendance.students;
    console.log(data);
      this.attendanceService.createNewAttendanceSheet(this.corID, this.isUpdated ,data).subscribe(
        res => {
          console.log(res);
          this.alert = new SuccessAlert();
          // this.router.navigate([`/course/${this.corID}/attendance`]);
          },
        error1 => {
          this.alert = new FailureAlert(error1);
          console.log(error1);
        }
      );
      //this.isUpdate = true ;
  };


  toggleStdAttendance(index) {
    this.attendance.students[index].isAttend = !this.attendance.students[index].isAttend;
    console.log(this.attendance.students);
  }
}
