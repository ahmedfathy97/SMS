import {CourseVto} from "./course-vto.data";
import {Announcement} from "./announcment";
import {StdDTO} from "./std-dto.data";
import {LectureVto} from "./lecture-vto";

export class CourseResultSet {
  list: CourseVto[] = [];
  announclist :Announcement [] = [] ;
  studentLis:StdDTO[]=[];
  totalRecords: number = 0;
  lectureList: LectureVto[];
  listStudent: CourseVto[] = [];

}
