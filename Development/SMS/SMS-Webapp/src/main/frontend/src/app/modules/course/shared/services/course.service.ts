import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseVto} from "../data/course-vto.data";
import {CourseDetailsData} from "../data/course/course-details.data";
import {StdDTO} from "../data/std-dto.data";


@Injectable()
export class CourseService {
  constructor(private http:HttpClient) { }

  getAllInstructorCourses() {
    return this.http.get<CourseVto[]>("http://localhost:8080/api/course/instructor/2")
  }

  //TODO: Youssef - rename to createNewCourse
  //TODO: Youssef - Use APP_BASE_URL &  BASE_URL
  addCourseData(details : CourseDetailsData){
    return this.http.post("http://localhost:8080/api/course/mainDetails", details);
  }

  getAllCourseStudents( courseID:number) {
    return this.http.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/students")
  }
  getCourseGrades(courseID:number){
    return this.http.get<StdDTO[]>("http://localhost:8080/api/course/"+courseID+"/grade")

  }





}
