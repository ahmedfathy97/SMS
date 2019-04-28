import {Subject} from "rxjs/internal/Subject";
import {Injectable} from "@angular/core";
@Injectable()
export class UserDataService {

  userID=new Subject<number>();
  requestUserID= new Subject<boolean>();

  constructor() { }

}
