import {AlertInput} from "./alert-input";

export class WarnAlert extends AlertInput{
  constructor(message: string){
    super('w', message);
  }
}
