import {QuizVTO} from "./quiz-vto-data";

export class StdDTO {
  id :number;
  fullName:string;
  isAttend : boolean = false ;
  midTermOne:number;
  semiFinal:number;
  midTermTwo:number;
  finalGrd:number;
  attendanceDate:Date;
  newGrade:number;
  quizes:QuizVTO []=[];
}
