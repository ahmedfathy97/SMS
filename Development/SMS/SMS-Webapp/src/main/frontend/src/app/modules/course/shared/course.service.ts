import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseType} from "./data/course-type-dto.data";
import {StdDto} from "./data/std-dto.data";
import {CourseDetailsData} from "./data/course/course-details.data";


@Injectable()
export class CourseService {
  constructor(private http:HttpClient) { }
  findCourseType() {
    return this.http.get<CourseType[]>("http://localhost:8080/api/lookup/CourseType")
  }
  addCourseData(details : CourseDetailsData){
    return this.http.post("http://localhost:8080/api/course/mainDetails", details);
  }
  findStdName( courseID:number) {
    return this.http.get<StdDto[]>("http://localhost:8080/api/Coursegrd/StdName/"+courseID)
  }

}
