import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseVto} from "../data/course-vto.data";
import {CourseDetailsData} from "../data/course/course-details.data";

import {StdDTO} from "../data/std-dto.data";
import {QuizDto} from "../data/quiz/quiz-dto";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {AttendanceDTO} from "../data/attendance-dto.data";


@Injectable()
export class CourseService {
  BASE_URL: string = ConfigParam.APP_BASE_URL ;
  constructor(private httpClient:HttpClient) { }

  getAllInstructorCourses() {
    return this.httpClient.get<CourseVto[]>("http://localhost:8080/api/course/instructor/2")
  }

  //TODO: Youssef - rename to createNewCourse
  //TODO: Youssef - Use APP_BASE_URL &  BASE_URL
  addCourseData(details : CourseDetailsData){
    return this.httpClient.post("http://localhost:8080/api/course/mainDetails", details);
  }


  getAllCourseStudents( courseID:number) {
    return this.httpClient.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/students")
  }

  getCourseGrades(courseID:number){
    return this.httpClient.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/grade")

  }
  getStudentGrades(courseID:number,studentID:number){
    return this.httpClient.get<StdDTO>("http://localhost:8080/api/course/"+ courseID+"/grade/student/"+studentID);

  }

  createNewQuiz(courseID:number,quizData: QuizDto) {
    return this.httpClient.post(this.BASE_URL + "/course/"+ courseID +"/quiz",quizData);
  }



  //TODO: Yara - this function will take courseID & attendanceData as Parameters
  //TODO: Yara - Create new Service modules/course/shared/services/attendance.service.ts
  //TODO: Yara - move this function to AttendanceService
  //TODO: Yara - rename to createNewAttendanceSheet
  //TODO: Yara - Use APP_BASE_URL &  BASE_URL

  getCourseAttendance (courseID :number){
    // return this.httpClient.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/attend")
    return this.httpClient.get<AttendanceDTO[]>("http://localhost:8080/api/course/"+courseID+"/attend")
  }

  getStudentAttendance (courseID :number , stdID : number){
    return this.httpClient.get<StdDTO[]>("http://localhost:8080/api/course"+courseID+"/student"+stdID)
  }
}
