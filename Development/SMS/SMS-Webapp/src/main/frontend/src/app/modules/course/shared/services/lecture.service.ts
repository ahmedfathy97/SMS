import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {LectureDto} from "../data/lecture-dto.data";
import {LectureVto} from "../data/lecture-vto";
import {ConfigParam} from "../../../../infrastructure/common/config-param";

@Injectable()
export class LectureService {
  // APP_BASE_URL : string ="http://localhost:8080/api";
  // BASE_URL : string = "/lecture/";
  BASE_URL: string = ConfigParam.APP_BASE_URL+"/lecture/";


  constructor(private http:HttpClient) {}

  getLectureData(lecID :number)
  {
    return this.http.get<LectureDto>(this.BASE_URL+lecID);
  }

}
