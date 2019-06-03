import {CourseVto} from "./course-vto.data";
import {Announcement} from "./announcment";
import {StdDTO} from "./std-dto.data";

export class CourseResultSet {
  list: CourseVto[] = [];
  announcList :Announcement [] = [] ;
  studentList:StdDTO[]=[];
  totalRecords: number = 0;

}
