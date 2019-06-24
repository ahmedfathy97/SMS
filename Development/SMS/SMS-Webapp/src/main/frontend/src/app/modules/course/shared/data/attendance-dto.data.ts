import {StdDTO} from "./std-dto.data";

export class AttendanceDTO {
   course_id : string ;
   attendanceData : Date ;
   students: StdDTO[] = [];
   attendCount : number  ;
  totalStd :number ;
}
