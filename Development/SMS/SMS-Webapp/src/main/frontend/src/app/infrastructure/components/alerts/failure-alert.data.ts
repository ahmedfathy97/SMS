import {AlertInput} from "./alert-input";
import {HttpErrorResponse} from "@angular/common/http";

export class FailureAlert extends AlertInput{

  constructor(error: HttpErrorResponse){
    super('f', error.error);
  }
}
