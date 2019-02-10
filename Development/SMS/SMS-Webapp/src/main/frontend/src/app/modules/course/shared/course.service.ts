import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseType} from "./data/course-type-dto.data";


@Injectable()
export class CourseService {
  constructor(private http:HttpClient) { }
  findCourseType() {
    return this.http.get<CourseType[]>("http://localhost:8080/api/lookup/CourseType")
  }

}
