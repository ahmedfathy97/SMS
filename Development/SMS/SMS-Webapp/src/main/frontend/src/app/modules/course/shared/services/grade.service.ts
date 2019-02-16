import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseGrd} from "../data/course-grd-dto.data";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {StdDTO} from "../data/std-dto.data";
//TODO: Hala - this function will take courseID & students as Parameters
//TODO: Hala - rename to createNewGradeSheet
//TODO: Hala - Create new Service modules/course/shared/services/grade.service.ts
//TODO: Hala - move this function to GradeService
//TODO: Hala - Use APP_BASE_URL &  BASE_URL

@Injectable()
export class GradeService {


  BASE_URL : string = ConfigParam.APP_BASE_URL  + "/grade";
  constructor(private http:HttpClient) {
  }
  createNewGradeSheet(  courseID:number,students: StdDTO[] ){
    return this.http.post(this.BASE_URL + `/${courseID}`,students);
  }
}