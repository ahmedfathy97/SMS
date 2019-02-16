import {Injectable} from "@angular/core";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {HttpClient} from "@angular/common/http";
import {QuizDto} from "../data/quiz/quiz-dto";


@Injectable()
export class QuizService {
  BASE_URL: string = ConfigParam.APP_BASE_URL +"/quiz" ;

  constructor(private httpClient:HttpClient){
  }

   createNewQuiz(quizData:QuizDto)
   {
     return this.httpClient.post(this.BASE_URL+"/new" ,quizData) ;
   }


}
