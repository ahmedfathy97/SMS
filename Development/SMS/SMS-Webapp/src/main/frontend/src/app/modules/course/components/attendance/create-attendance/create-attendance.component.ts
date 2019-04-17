import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {CourseVto} from "../../../shared/data/course-vto";
import {CourseService} from "../../../shared/services/course.service";
import {AttendanceDTO} from "../../../shared/data/attendance-dto.data";
import {AttendanceService} from "../../../shared/services/attendance.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-create-attendance',
  templateUrl: './create-attendance.component.html',
  providers: [FormBuilder, CourseService ,AttendanceService],
})
export class CreateAttendanceComponent implements OnInit {
  courseID: string;
  corID :number ;
  formData = this.formBuilder.group({
    //courseID: ['', Validators.required],
    attendanceDate: ['', Validators.required]
  });
 //courses: CourseVto [] = [];

  attendance: AttendanceDTO = new AttendanceDTO();

  constructor(private formBuilder: FormBuilder, private  courseService: CourseService , private  attendanceService: AttendanceService ,
              private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
    })
  }

  ngOnInit() {
    var courseID = +this.courseID;
    this.corID = courseID ;
    this.courseService.getAllCourseStudents(this.corID).subscribe(
      res => {
        this.attendance.students = res;
        console.log(this.attendance.students);

      }
    );
  }

  exist : boolean = false ;

  onSubmitNewAttendance() {
    let data: AttendanceDTO = new AttendanceDTO();
    //data.course_id = this.formData.get('courseID').value;
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
