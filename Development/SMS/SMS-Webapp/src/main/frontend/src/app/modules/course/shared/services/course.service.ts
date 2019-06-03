import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {CourseDTO} from "../data/course/course-dto.data";
import {CourseVto} from "../data/course-vto";
import {StdDTO} from "../data/std-dto.data";
import {QuizDto} from "../data/quiz/quiz-dto";
import {AttendanceDTO} from "../data/attendance-dto.data";
import {CourseQuizesVto} from "../data/quiz/course-quizes-vto";
import {LectureDto} from "../data/lecture-dto.data";
import {Announcement} from "../data/announcment";
import {CourseResultSet} from "../data/course-result-set.data";
import {LectureVto} from "../data/lecture-vto";
import {isBoolean} from "util";


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


  getAllCourseStudents( courseID:number, gradeType:string, attendanceDate:Date) {
    let parameters: HttpParams = new HttpParams();
    if (gradeType != null)
      parameters = parameters.append('gradeType', gradeType);
    if (attendanceDate != null)
      parameters = parameters.append('attendanceDate', attendanceDate.toString());

    return this.httpClient.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/students",
      {params: parameters});
  }

  getCourseGrades(courseID:number,pageNum:number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/grade",
      {params: queryParameter}

      );

  }
  getStudentGrades(courseID:number,studentID:number){
    return this.httpClient.get<StdDTO>("http://localhost:8080/api/course/"+ courseID+"/grade/student/"+studentID);

  }

  createNewQuiz(courseID:number,quizData: QuizDto) {
    return this.httpClient.post<number>(this.APP_BASE_URL+this.BASE_URL+ courseID +"/newQuiz",quizData);
  }

  createNewLecture(courseID :number ,lectureDto : LectureDto){
    return this.httpClient.post(this.APP_BASE_URL+this.BASE_URL+courseID+"/lecture", lectureDto);
  }


  getCourseQuizes(courseID :number)
  {
    return this.httpClient.get<CourseQuizesVto[]>(this.APP_BASE_URL+this.BASE_URL+courseID +"/quizes");
  }

  // findAllCourses(courseID :number){
  //   return this.httpClient.get<CourseVto[]>("http://localhost:8080/api/course/"+courseID);
  // }
  findAllCourses(pageNum: number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>("http://localhost:8080/api/course/all",
      {params: queryParameter});

  }
  findAllMyCourses(pageNum: number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>("http://localhost:8080/api/course",{params: queryParameter});
  }



  getCourseAttendance (courseID :number){
    return this.httpClient.get<AttendanceDTO[]>(this.APP_BASE_URL+this.BASE_URL +courseID+"/attendance")
  }

  getStudentAttendance (courseID :number , stdID : number){
    return this.httpClient.get<AttendanceDTO[]>("http://localhost:8080/api/course/"+courseID+"/student/"+stdID)
  }

  getCourseByID(corID: number){
    return this.httpClient.get<CourseVto>(this.APP_BASE_URL+this.BASE_URL+corID);

  }

  enrollStudentByID(corID: number){
    return this.httpClient.post("http://localhost:8080/api/course/"+corID+"/enroll",null);
    // return this.httpClient.post("http://localhost:8080/api/student/enroll");

  }
  getStudentIsEnroll(corID: number){
    return this.httpClient.get<boolean>("http://localhost:8080/api/course/"+corID+"/isStudent");

  }

  createNewAnnouncement(courseID: number, announcement : Announcement) {
    return this.httpClient.post(this.APP_BASE_URL+this.BASE_URL + courseID +"/newAnnouncment", announcement);
  }

  getCourseAnnouncments(courseID :number , pageNum : number )
  {
    let queryParam : HttpParams = new HttpParams () ;
    queryParam = queryParam.append('pageNum',pageNum.toString());
    return this.httpClient.get<Announcement[]>(this.APP_BASE_URL+this.BASE_URL +courseID +"/announcmentList" ,
      {params: queryParam}) ;
  }
  // getCourseAnnouncments(courseID :number )
  // {
  //   return this.httpClient.get<Announcement[]>(this.APP_BASE_URL+this.BASE_URL +courseID +"/announcmentList") ;
  // }

  getCourseLectures(courseID :number)
  {
    return this.httpClient.get<LectureVto[]>(this.APP_BASE_URL+this.BASE_URL+courseID +"/lectures");
  }
}

