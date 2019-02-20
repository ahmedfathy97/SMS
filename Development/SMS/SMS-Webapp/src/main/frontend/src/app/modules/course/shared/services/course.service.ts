import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseVto} from "../data/course-vto.data";
import {CourseDetailsData} from "../data/course/course-details.data";
import {StdDTO} from "../data/std-dto.data";
import {QuizDto} from "../data/quiz/quiz-dto";
import {ConfigParam} from "../../../../infrastructure/common/config-param";


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


  createNewQuiz(courseID:number,quizData: QuizDto) {
    return this.httpClient.post(this.BASE_URL + "/course/"+ courseID +"/quiz",quizData);
  }




}
