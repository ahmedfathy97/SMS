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
    return this.http.post(this.APP_BASE_URL+this.BASE_URL+ courseID +"/quiz",quizData);
  }

  // getCloseDate(courseID : number ,quizID : number )
  // {
  //   return this.http.get<QuizDto>(this.APP_BASE_URL +this.BASE_URL + courseID + "/quiz/"+ quizID + "/close");
  //
  // }




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
