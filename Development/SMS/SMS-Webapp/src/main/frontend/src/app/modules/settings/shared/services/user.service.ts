import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
//import {UserData} from "../data/user-data";
import {Observable} from "rxjs/internal/Observable";
import {College} from "../data/college";
import {University} from "../data/university";
import {Country} from "../data/country";
import {UserVtoData} from "../data/user-vto.data";
import {UserResultSet} from "../data/user-result-set.data";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {findAll} from "@angular/compiler-cli/src/ngcc/src/utils";

@Injectable()
export class UserService {
  // APP_BASE_URL : string ="http://localhost:8080/api";
  // BASE_URL : string ="/user/";
  BASE_URL: string = ConfigParam.APP_BASE_URL+"/user/";

  constructor( private http:HttpClient){}

  findByID(userID:number){
 //return this.http.get<UserData>(this.APP_BASE_URL+this.BASE_URL+userID);
    return this.http.get<UserVtoData>(this.BASE_URL+userID+"/profile");
  }

  editProfile(userID:number ,edit:UserVtoData){
    return this.http.post(this.BASE_URL+userID+"/edit",edit);

  }

  filter(data:UserVtoData){
    return this.http.post(this.BASE_URL+"filter",data);

  }

  findallcollege(){
    return this.http.get<College[]>(this.BASE_URL+"colleges");

  }

  findalluniversity(){
    return this.http.get<University[]>(this.BASE_URL+"university")
  }

  findallcountry(){
    return this.http.get<Country[]>(this.BASE_URL+"country")
  }

  findAll(pageNum: number){
    let queryParameter: HttpParams = new HttpParams();

    queryParameter = queryParameter.append('pageNum', pageNum.toString());

    return this.http.get<UserResultSet>(this.BASE_URL + "find",{params: queryParameter})
  }
  updateProfileImg(userID: number, profileImg: File) {
    const params = new HttpParams()
      .set("fileName", profileImg.name)
      .set("fileType", profileImg.type);

    let formData: FormData = new FormData();
    formData.append("file", profileImg);
    return this.http.post(this.BASE_URL+ userID + "/img", formData, {params: params});
  }
}
