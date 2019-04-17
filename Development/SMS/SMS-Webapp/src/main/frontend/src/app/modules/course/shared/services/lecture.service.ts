import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {LectureDto} from "../data/lecture-dto.data";

@Injectable()
export class LectureService {
  APP_BASE_URL : string ="http://localhost:8080/api";
  Base_URL : string = "/lecture/";

  constructor(private http:HttpClient) {}


}
