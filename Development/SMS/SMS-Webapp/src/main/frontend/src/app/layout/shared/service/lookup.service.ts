import {HttpClient} from "@angular/common/http";
import {CorDetailsCategoryData} from "../../../modules/course/shared/data/lookup/course/cor-details-category.data";
import {CorDetailsTypeData} from "../../../modules/course/shared/data/lookup/course/cor-details-type.data";
import {CorDetailsLevelData} from "../../../modules/course/shared/data/lookup/course/cor-details-level.data";
import {Injectable} from "@angular/core";


@Injectable()
export class LookupService {


  BASE_URL : string =  "http://localhost:8080/api/lookup";

  constructor(private http: HttpClient) {
  }
  findCorCategory(){
    return this.http.get<CorDetailsCategoryData>(this.BASE_URL+"/corCategory");
  }
  findCorType(){
    return this.http.get<CorDetailsTypeData>(this.BASE_URL+"/corType");
  }
  findCorLevel(){
    return this.http.get<CorDetailsLevelData>(this.BASE_URL+"/corLevel");
  }
}
