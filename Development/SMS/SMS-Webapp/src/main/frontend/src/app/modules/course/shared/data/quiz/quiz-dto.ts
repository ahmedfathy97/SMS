import {DateFormatter} from "@angular/common/src/pipes/deprecated/intl";

export class QuizDto {
  quizName :	string ;
  grade	:number ;
  startDate: Date ;
  finishDate :Date ;
  isClosed : boolean =false ;
}
