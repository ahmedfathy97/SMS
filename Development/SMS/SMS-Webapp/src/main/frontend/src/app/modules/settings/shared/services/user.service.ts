import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
//import {UserData} from "../data/user-data";
import {Observable} from "rxjs/internal/Observable";
import {College} from "../data/college";
import {University} from "../data/university";
import {Country} from "../data/country";
import {UserVtoData} from "../data/user-vto.data";
import {ConfigParam} from "../../../../infrastructure/common/config-param";

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

  findAll(){
    return this.http.get<UserVtoData[]>(this.BASE_URL+"find")
  }
  // public uploadImage(image: File): Observable<Response> {
  //   const formData = new FormData();
  //
  //   formData.append('image', image);
  //
  //   return this.http.post('/api/v1/image-upload', formData);
  // }
}
