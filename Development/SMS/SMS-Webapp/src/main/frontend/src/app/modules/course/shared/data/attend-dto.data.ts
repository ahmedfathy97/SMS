import {StdDto} from "./std-dto.data";

export class AttendData {
   course_id : string ;
   date : Date ;
   stdList: StdDto[] = [];
}
