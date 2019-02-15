import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseVto} from "../data/course-vto.data";
import {AttendanceDTO} from "../data/attendance-dto.data";
import {CourseGrd} from "../data/course-grd-dto.data";
import {CourseDetailsData} from "../data/course/course-details.data";
import {StdDTO} from "../data/std-dto.data";


@Injectable()
export class CourseService {
  constructor(private http:HttpClient) { }
  //TODO: Yara - rename to getAllInstructorCourses
  getAllInstructorCourses() {
    return this.http.get<CourseVto[]>("http://localhost:8080/api/course/instructor/2")
  }

  //TODO: Youssef - rename to createNewCourse
  //TODO: Youssef - Use APP_BASE_URL &  BASE_URL
  addCourseData(details : CourseDetailsData){
    return this.http.post("http://localhost:8080/api/course/mainDetails", details);
  }

  //TODO: Hala - rename to getAllCourseStudents
  getAllCourseStudents( courseID:number) {
    return this.http.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/students")
  }
  getCourseGrades(courseID:number){
    return this.http.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/grade")

  }




  //TODO: Yara - this function will take courseID & attendanceData as Parameters
  //TODO: Yara - Create new Service modules/course/shared/services/attendance.service.ts
  //TODO: Yara - move this function to AttendanceService
  //TODO: Yara - rename to createNewAttendanceSheet
  //TODO: Yara - Use APP_BASE_URL &  BASE_URL

}
