import {Injectable} from "@angular/core";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {HttpClient} from "@angular/common/http";
import {QuizDto} from "../data/quiz/quiz-dto";
import {QuestionType} from "../data/quiz/question-type";


@Injectable()
export class QuizService {
  BASE_URL: string = ConfigParam.APP_BASE_URL ;

  constructor(private httpClient: HttpClient) {
  }


  getAllQuestionsTypes()
  {
    return this.httpClient.get<QuestionType[]>(this.BASE_URL+"/lookup/questionType") ;
  }


}
