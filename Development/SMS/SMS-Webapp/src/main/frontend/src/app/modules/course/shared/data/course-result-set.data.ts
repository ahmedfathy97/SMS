import {CourseVto} from "./course-vto.data";
import {Announcement} from "./announcment";

export class CourseResultSet {
  list: CourseVto[] = [];
  announcList :Announcement [] = [] ;
  totalRecords: number = 0;
}
