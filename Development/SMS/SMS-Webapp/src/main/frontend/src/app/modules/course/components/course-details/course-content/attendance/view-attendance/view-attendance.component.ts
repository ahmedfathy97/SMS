import { Component, OnInit } from '@angular/core';
import {AttendanceService} from "../../../../../shared/services/attendance.service";
import {CourseService} from "../../../../../shared/services/course.service";
import {StdDTO} from "../../../../../shared/data/std-dto.data";
import {AttendanceDTO} from "../../../../../shared/data/attendance-dto.data";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {AuthUserVTO} from "../../../../../../security/shared/data/auth-user-vto.data";
import {LocalStorageService} from "../../../../../../../infrastructure/services/local-storage.service";
import {AuthRoles} from "../../../../../../../infrastructure/directives/authorization/data/auth-roles.enum";

@Component({
  selector: 'app-view-attendance',
  templateUrl: './view-attendance.component.html',
  styles: [`
    .attendance-col { width: 150px;}
    .name-col { width: 300px;}
    .id-col { width: 10px;}
  `],
  providers : [CourseService]
})
export class ViewAttendanceComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  AUTH_ROLES: typeof AuthRoles = AuthRoles;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  display : boolean = false ;
  corID :number ;
  attendanceList :AttendanceDTO [] = [];
  tableView : any [][] ;
  
  currentUser: AuthUserVTO = new AuthUserVTO();
  constructor( private attendanceService : CourseService ,
               private localStorageService: LocalStorageService,
               private corDataService: CourseDataService){
    this.currentUser = this.localStorageService.getCurrentUser();
    // this.currentUser.roleIDs.
      this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
        this.getCourseAttendance();
      }
      );
    this.corDataService.requestCorID.next(true);


  }
  
  
  corName: string;
  ngOnInit() {
    this.attendanceService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
  }

  getCourseAttendance(){
    this.attendanceService.getCourseAttendance(this.corID).subscribe(
      res => {
        this.attendanceList = res;
        console.log(this.attendanceList);
        this.transformTable();

        if (this.attendanceList.length != 0 )
        {
          this.display=true;
        }
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
    console.log(this.tableView);
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
