import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AttendanceDTO} from "../data/attendance-dto.data";

@Injectable()
export class AttendanceService {
  //TODO: Yara - Use APP_BASE_URL &  BASE_URL
  BASE_URL : string ="http://localhost:8080/api/attendance";
  constructor(private http:HttpClient) { }

  createNewAttendanceSheet( courseID : number ,attendanceData : AttendanceDTO){
    return this.http.post( this.BASE_URL +"/2", attendanceData);
  }

}

