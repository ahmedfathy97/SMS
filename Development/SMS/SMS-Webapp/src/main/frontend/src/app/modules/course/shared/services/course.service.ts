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
import {CourseExamsVto} from "../data/quiz/course-exams-vto";
import {ConfigParam} from "../../../../infrastructure/common/config-param";


@Injectable()
export class CourseService {
  // APP_BASE_URL : string ="http://localhost:8080/api";
  BASE_URL: string = ConfigParam.APP_BASE_URL+"/course/";

  // BASE_URL : string = "/course/";


  constructor(private httpClient:HttpClient) { }

  getAllInstructorCourses() {
    return this.httpClient.get<CourseVto[]>(this.BASE_URL+"instructor/2")
  }


  createNewCourse(details : CourseDTO){
    return this.httpClient.post<number>(this.BASE_URL , details);
  }

  // updateCourseImage(corID: number, image: File){
  //   return this.httpClient.post(this.APP_BASE_URL+this.BASE_URL , details);
  // }


  getAllCourseStudents( courseID:number, gradeType:string, attendanceDate:Date) {
    let parameters: HttpParams = new HttpParams();
    if (gradeType != null)
      parameters = parameters.append('gradeType', gradeType);
    if (attendanceDate != null)
      parameters = parameters.append('attendanceDate', attendanceDate.toString());

    return this.httpClient.get<StdDTO[]>(this.BASE_URL+courseID+"/students",
      {params: parameters});
  }

  getCourseGrades(courseID:number,pageNum:number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>(this.BASE_URL+courseID+"/grade",
      {params: queryParameter}

      );

  }
  getQuizGrades(courseID:number){
    return this.httpClient.get<StdDTO[]>(this.BASE_URL+ courseID+"/grade/quizes");
  }


  getStudentGrades(courseID:number,studentID:number){
    return this.httpClient.get<StdDTO>(this.BASE_URL+ courseID+"/grade/student/"+studentID);

  }

  createNewQuiz(courseID:number,quizData: QuizDto) {
    return this.httpClient.post<number>(this.BASE_URL+ courseID +"/newQuiz",quizData);
  }

  createNewLecture(courseID :number ,lectureDto : LectureDto){
    return this.httpClient.post(this.BASE_URL+courseID+"/lecture", lectureDto);
  }


  getCourseQuizes(courseID :number)
  {
    return this.httpClient.get<CourseQuizesVto[]>(this.BASE_URL+courseID +"/quizes");
  }

  getCourseExams(courseID :number)
  {
    return this.httpClient.get<CourseExamsVto[]>(this.BASE_URL+courseID +"/exams");
  }

  // findAllCourses(courseID :number){
  //   return this.httpClient.get<CourseVto[]>("http://localhost:8080/api/course/"+courseID);
  // }
  findAllCourses(pageNum: number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>(this.BASE_URL+"all",
      {params: queryParameter});

  }
  findAllMyCourses(pageNum: number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>(this.BASE_URL,{params: queryParameter});
  }



  getCourseAttendance (courseID :number){
    return this.httpClient.get<AttendanceDTO[]>(this.BASE_URL +courseID+"/attendance")
  }

  getStudentAttendance (courseID :number , stdID : number){
    return this.httpClient.get<AttendanceDTO[]>(this.BASE_URL+courseID+"/student/"+stdID)
  }

  getCourseByID(corID: number){
    return this.httpClient.get<CourseVto>(this.BASE_URL+corID);

  }

  enrollStudentByID(corID: number){
    return this.httpClient.post(this.BASE_URL+corID+"/enroll",null);
    // return this.httpClient.post("http://localhost:8080/api/student/enroll");

  }
  getStudentIsEnroll(corID: number){
    return this.httpClient.get<boolean>(this.BASE_URL+corID+"/isStudent");

  }

  createNewAnnouncement(courseID: number, announcement : Announcement) {
    return this.httpClient.post(this.BASE_URL+ courseID +"/newAnnouncment", announcement);
  }

  getCourseAnnouncments(courseID :number , pageNum : number )
  {
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>(this.BASE_URL+courseID +"/announcmentList" ,
      {params: queryParameter}) ;
  }
  // getCourseAnnouncments(courseID :number )
  // {
  //   return this.httpClient.get<Announcement[]>(this.APP_BASE_URL+this.BASE_URL +courseID +"/announcmentList") ;
  // }

  getCourseLectures(courseID :number,pageNum : number)
  {
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());
    return this.httpClient.get<CourseResultSet>(this.BASE_URL+courseID +"/lectures",{params: queryParameter});
  }

  updateCourseImg(corID: number, courseImg: File) {
    const params = new HttpParams()
      .set("fileName", courseImg.name)
      .set("fileType", courseImg.type);

    let formData: FormData = new FormData();
    formData.append("file", courseImg);
    return this.httpClient.post(this.BASE_URL+ corID + "/img", formData, {params: params});
  }

}

