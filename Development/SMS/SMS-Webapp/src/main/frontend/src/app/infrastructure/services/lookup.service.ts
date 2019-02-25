import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {CorCategory} from "../../modules/course/shared/data/lookup/course/cor-category.data";
import {CorType} from "../../modules/course/shared/data/lookup/course/cor-type.data";
import {CorLevel} from "../../modules/course/shared/data/lookup/course/cor-level.data";


@Injectable()
export class LookupService {

  BASE_URL : string =  "http://localhost:8080/api/lookup";

  constructor(private http: HttpClient) {
  }
  findCorCategory(){
    return this.http.get<CorCategory[]>(this.BASE_URL+"/corCategoryList");
  }
  findCorType(){
    return this.http.get<CorType[]>(this.BASE_URL+"/corTypeList");
  }
  findCorLevel(){
    return this.http.get<CorLevel[]>(this.BASE_URL+"/corLevelList");
  }
}
