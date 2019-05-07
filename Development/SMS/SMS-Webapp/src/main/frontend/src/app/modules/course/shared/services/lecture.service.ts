import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {LectureDto} from "../data/lecture-dto.data";
import {LectureVto} from "../data/lecture-vto";

@Injectable()
export class LectureService {
  APP_BASE_URL : string ="http://localhost:8080/api";
  BASE_URL : string = "/lecture/";

  constructor(private http:HttpClient) {}

  getLectureData(lecID :number)
  {
    return this.http.get<LectureDto>(this.APP_BASE_URL+this.BASE_URL+lecID);
  }

}
