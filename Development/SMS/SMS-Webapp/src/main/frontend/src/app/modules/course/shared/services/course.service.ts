import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseDTO} from "../data/course/course-dto.data";
import {CourseVto} from "../data/course-vto";
import {StdDTO} from "../data/std-dto.data";
import {QuizDto} from "../data/quiz/quiz-dto";
import {AttendanceDTO} from "../data/attendance-dto.data";


@Injectable()
export class CourseService {
  APP_BASE_URL : string ="http://localhost:8080/api";
  BASE_URL : string ="/course/";


  constructor(private http:HttpClient) { }

  getAllInstructorCourses() {
    return this.http.get<CourseVto[]>("http://localhost:8080/api/course/instructor/2")
  }

  //TODO: Youssef - rename to createNewCourse
  //TODO: Youssef - Use APP_BASE_URL &  BASE_URL
  createNewCourse(details : CourseDTO){
    return this.http.post(this.APP_BASE_URL+this.BASE_URL , details);
  }


  getAllCourseStudents( courseID:number) {
    return this.http.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/students")
  }

  getCourseGrades(courseID:number){
    return this.http.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/grade")

  }
  getStudentGrades(courseID:number,studentID:number){
    return this.http.get<StdDTO>("http://localhost:8080/api/course/"+ courseID+"/grade/student/"+studentID);

  }

  createNewQuiz(courseID:number,quizData: QuizDto) {
    return this.http.post(this.BASE_URL + "/course/"+ courseID +"/quiz",quizData);
  }



  //TODO: Yara - this function will take courseID & attendanceData as Parameters
  //TODO: Yara - Create new Service modules/course/shared/services/attendance.service.ts
  //TODO: Yara - move this function to AttendanceService
  //TODO: Yara - rename to createNewAttendanceSheet
  //TODO: Yara - Use APP_BASE_URL &  BASE_URL

  getCourseAttendance (courseID :number){
    return this.http.get<AttendanceDTO[]>("http://localhost:8080/api/course/"+courseID+"/attend")
  }

  getStudentAttendance (courseID :number , stdID : number){
    return this.http.get<AttendanceDTO[]>("http://localhost:8080/api/course/"+courseID+"/student/"+stdID)
  }

  getCourseByID(corID: number){
    return this.http.get<CourseVto>(this.APP_BASE_URL+this.BASE_URL+corID);

  }
}
