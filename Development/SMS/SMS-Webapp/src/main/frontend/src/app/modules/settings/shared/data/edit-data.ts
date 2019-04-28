import {Subject} from "rxjs/internal/Subject";
import {Injectable} from "@angular/core";

@Injectable()
export class EditData {
   userID=new Subject<number>();
   constructor() { }

}
