import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseType} from "./data/course-type-dto.data";
import {StdDto} from "./data/std-dto.data";
import {AttendData} from "./data/attend-dto.data";
import {CourseGrd} from "./data/course-grd-dto.data";
import {CourseDetailsData} from "./data/course/course-details.data";


@Injectable()
export class CourseService {
  constructor(private http:HttpClient) { }
  //TODO: Yara - rename to getAllInstructorCourses
  findCourseType() {
    return this.http.get<CourseType[]>("http://localhost:8080/api/lookup/CourseType/2")
  }

  //TODO: Youssef - rename to createNewCourse
  //TODO: Youssef - Use APP_BASE_URL &  BASE_URL
  addCourseData(details : CourseDetailsData){
    return this.http.post("http://localhost:8080/api/course/mainDetails", details);
  }

  //TODO: Hala - rename to getAllCourseStudents
  findStdName( courseID:number) {
    return this.http.get<StdDto[]>("http://localhost:8080/api/Coursegrd/StdName/"+courseID)
  }

  //TODO: Hala - this function will take courseID & students as Parameters
  //TODO: Hala - rename to createNewGradeSheet
  //TODO: Hala - Create new Service modules/course/shared/services/grade.service.ts
  //TODO: Hala - move this function to GradeService
  //TODO: Hala - Use APP_BASE_URL &  BASE_URL
  saveStdGrades( data:CourseGrd){
    return this.http.post("http://localhost:8080/api/Coursegrd/stdGrd/2",data.students)
  }

  //TODO: Yara - this function will take courseID & attendanceData as Parameters
  //TODO: Yara - Create new Service modules/course/shared/services/attendance.service.ts
  //TODO: Yara - move this function to AttendanceService
  //TODO: Yara - rename to createNewAttendanceSheet
  //TODO: Yara - Use APP_BASE_URL &  BASE_URL
  saveAttendData(data : AttendData){
    return this.http.post( "http://localhost:8080/api/attendance/student/2", data);
  }

}
