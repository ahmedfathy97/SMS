import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {UserVto} from "./data/user-vto";

@Injectable()
export class UserService {
  APP_BASE_URL : string ="http://localhost:8080/api";
  BASE_URL : string ="/user/";
  constructor( private http:HttpClient){}

  findByID(userID:number){
 return this.http.get<UserVto>(this.APP_BASE_URL+this.BASE_URL+userID);

  }

}
