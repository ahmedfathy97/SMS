import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseDTO} from "../data/course/course-dto.data";
import {CourseVto} from "../data/course-vto";
import {StdDTO} from "../data/std-dto.data";
import {QuizDto} from "../data/quiz/quiz-dto";
import {AttendanceDTO} from "../data/attendance-dto.data";
import {CourseQuizesVto} from "../data/quiz/course-quizes-vto";
import {LectureDto} from "../data/lecture-dto.data";


@Injectable()
export class CourseService {
  APP_BASE_URL : string ="http://localhost:8080/api";
  BASE_URL : string = "/course/";


  constructor(private httpClient:HttpClient) { }

  getAllInstructorCourses() {
    return this.httpClient.get<CourseVto[]>("http://localhost:8080/api/course/instructor/2")
  }


  createNewCourse(details : CourseDTO){
    return this.httpClient.post(this.APP_BASE_URL+this.BASE_URL , details);
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
    return this.httpClient.post(this.APP_BASE_URL+this.BASE_URL+ courseID +"/quiz",quizData);
  }

  createNewLecture(courseID :number ,lectureDto : LectureDto){
    return this.httpClient.post(this.APP_BASE_URL+this.BASE_URL+courseID+"/lecture", lectureDto);
  }


  getCourseQuizes(courseID :number)
  {
    return this.httpClient.get<CourseQuizesVto[]>(this.APP_BASE_URL+this.BASE_URL+courseID +"/quizes");
  }



  getCourseAttendance (courseID :number){
    return this.httpClient.get<AttendanceDTO[]>("http://localhost:8080/api/course/"+courseID+"/attend")
  }

  getStudentAttendance (courseID :number , stdID : number){
    return this.httpClient.get<AttendanceDTO[]>("http://localhost:8080/api/course/"+courseID+"/student/"+stdID)
  }

  getCourseByID(corID: number){
    return this.httpClient.get<CourseVto>(this.APP_BASE_URL+this.BASE_URL+corID);

  }

  enrollStudentByID(corID: number){
    return this.httpClient.post("http://localhost:8080/api/student/enroll/",corID);
    return this.httpClient.post("http://localhost:8080/api/student/enroll/"+corID, null);

  }
}
