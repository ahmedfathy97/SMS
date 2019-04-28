import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserData} from "../data/user-data";
import {Observable} from "rxjs/internal/Observable";
import {College} from "../data/college";
import {University} from "../data/university";
import {Country} from "../data/country";
import {UserVtoData} from "../data/user-vto.data";

class UserVTO {
}

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

  filter(data:UserVtoData){
    return this.http.post("http://localhost:8080/api/user/filter",data);

  }

  findallcollege(){
    return this.http.get<College[]>("http://localhost:8080/api/user/colleges");

  }

  findalluniversity(){
    return this.http.get<University[]>("http://localhost:8080/api/user/university")
  }

  findallcountry(){
    return this.http.get<Country[]>("http://localhost:8080/api/user/country")
  }

  findAll(){
    return this.http.get<UserVtoData[]>("http://localhost:8080/api/user/find")
  }
  // public uploadImage(image: File): Observable<Response> {
  //   const formData = new FormData();
  //
  //   formData.append('image', image);
  //
  //   return this.http.post('/api/v1/image-upload', formData);
  // }
}
