import {StdDto} from "./std-dto.data";

export class AttendanceDTO {
   course_id : string ;
   attendanceData : Date ;
   students: StdDto[] = [];
}
