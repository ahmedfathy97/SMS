import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {StdDTO} from "../data/std-dto.data";


@Injectable()
export class GradeService {
  BASE_URL : string = ConfigParam.APP_BASE_URL  + "/grade/";

  constructor(private http:HttpClient) {
  }

  createNewGradeSheet(courseID:number, students: StdDTO[],gradeType:string){
    let parameters: HttpParams = new HttpParams();
    parameters = parameters.append('gradeType', gradeType);

    return this.http.post(this.BASE_URL +courseID+"/new" ,students,
      {params: parameters});
  }



}
