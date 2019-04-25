import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserData} from "./data/user-data";
import {Observable} from "rxjs/internal/Observable";

@Injectable()
export class UserService {
  // APP_BASE_URL : string ="http://localhost:8080/api";
  // BASE_URL : string ="/user/";
  constructor( private http:HttpClient){}

  findByID(userID:number){
 //return this.http.get<UserData>(this.APP_BASE_URL+this.BASE_URL+userID);
    return this.http.get<UserData>("http://localhost:8080/api/user/"+userID+"/profile");
  }

 editProfile(userID:number){
    return this.http.get<UserData>("http://localhost:8080/api/user/"+userID+"/edit");

  }

  // public uploadImage(image: File): Observable<Response> {
  //   const formData = new FormData();
  //
  //   formData.append('image', image);
  //
  //   return this.http.post('/api/v1/image-upload', formData);
  // }
}
