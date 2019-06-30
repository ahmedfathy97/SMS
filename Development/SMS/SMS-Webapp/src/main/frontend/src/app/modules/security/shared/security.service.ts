import {HttpClient, HttpHeaders} from "@angular/common/http";
import {RegisterDTO} from "./data/register-dto.data";
import {Injectable} from "@angular/core";
import {LoginDTO} from "./data/login-dto.data";
import {AuthUserVTO} from "./data/auth-user-vto.data";
import {RolesVto} from "./data/roles-Vto";

@Injectable()
export class SecurityService {
  APP_BASE_URL : string ="http://localhost:8080/api";
  constructor(private http: HttpClient){

  }

  register(data: RegisterDTO){
    return this.http.post(this.APP_BASE_URL+'/register', data);
  }

  login(data: LoginDTO){
    return this.http.post<AuthUserVTO>(this.APP_BASE_URL+'/login', data);
  }

  getAllRoles()
  {
    return this.http.get<RolesVto[]>(this.APP_BASE_URL+'/roles') ;
  }

  testAuthentication(){
    return this.http.get(this.APP_BASE_URL+'/test');
  }

  testAction(){
    return this.http.get(this.APP_BASE_URL+'/test-action');
  }

  testView(){
    return this.http.get(this.APP_BASE_URL+'/test-view');
  }
}
