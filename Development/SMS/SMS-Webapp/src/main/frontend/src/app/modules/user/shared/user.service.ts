import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserVto} from "./data/user-vto";
import {Observable} from "rxjs/internal/Observable";
import {EditVto} from "./data/edit-vto";
@Injectable()
export class UserService {
  // APP_BASE_URL : string ="http://localhost:8080/api";
  // BASE_URL : string ="/user/";
  constructor( private http:HttpClient){}

  findByID(userID:number){
 //return this.http.get<UserVto>(this.APP_BASE_URL+this.BASE_URL+userID);
    return this.http.get<UserVto>("http://localhost:8080/api/user/"+userID);
  }

  findBYID(userID:number){
    return this.http.get<EditVto>("http://localhost:8080/api/edit/"+userID);

  }

  // public uploadImage(image: File): Observable<Response> {
  //   const formData = new FormData();
  //
  //   formData.append('image', image);
  //
  //   return this.http.post('/api/v1/image-upload', formData);
  // }
}
