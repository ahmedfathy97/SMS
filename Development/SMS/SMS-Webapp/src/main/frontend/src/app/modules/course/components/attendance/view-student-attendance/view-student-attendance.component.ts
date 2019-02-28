import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../shared/services/course.service";
import {AttendanceDTO} from "../../../shared/data/attendance-dto.data";

@Component({
  selector: 'app-view-student-attendance',
  templateUrl: './view-student-attendance.component.html',
  styleUrls: ['./view-student-attendance.component.scss'],
  providers : [CourseService]

})
export class ViewStudentAttendanceComponent implements OnInit {

  attendanceList :AttendanceDTO [] = [];
  tableView : any [][] ;
  constructor( private attendanceService : CourseService ) { }

  ngOnInit() {


    this.attendanceService.getStudentAttendance(2 , 1).subscribe(
      res => {
        this.attendanceList = res;
        console.log(this.attendanceList);
        this.transformTable();
      }
    )

  }

  transformTable(){
    if (this.attendanceList.length != 0 ) {
      this.tableView = [];
      this.tableView[0] = [];
      this.tableView[0][0] = 'Name';

      for (let i = 0; i < this.attendanceList.length; i++)
        this.tableView[0][i + 1] = this.attendanceList[i].attendanceData;

      for (let i = 0; i < this.attendanceList[0].students.length; i++) {

        this.tableView[i + 1] = [];
        for(let j = 0 ; j < this.tableView[0].length ; j++)
          this.tableView[i+1][j]=false ;

        this.tableView[i + 1][0] = this.attendanceList[0].students[i].fullName;
      }

      for (let i = 1 ; i < this.tableView.length;i++){
        for (let j = 1 ; j < this.tableView[i].length;j++){
          this.tableView[i][j]=this.mapStdAttend(this.tableView[i][0],this.tableView[0][j]);
        }
      }

    }
  }
  mapStdAttend(stdName , sheetDate){
    for (let sheet of this.attendanceList){
      if (sheet.attendanceData == sheetDate) {
        for (let std of sheet.students){
          if (std.fullName == stdName){
            return std.isAttend ;
          }
        }

      }

    }


    return false ;
  }


}
