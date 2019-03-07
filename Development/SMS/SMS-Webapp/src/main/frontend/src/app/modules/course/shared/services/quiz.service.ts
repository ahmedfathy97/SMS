import {Injectable} from "@angular/core";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {HttpClient} from "@angular/common/http";
import {QuizDto} from "../data/quiz/quiz-dto";
import {QuestionType} from "../data/quiz/question-type";
import {QuestionDto} from "../data/quiz/question-dto";
import {QuestionVto} from "../data/quiz/question-vto";


@Injectable()
export class QuizService {
  BASE_URL: string = ConfigParam.APP_BASE_URL ;


  constructor(private httpClient: HttpClient) {
  }


  createQuizQuestions(quizId: number ,questionsList:QuestionDto[])
  {
    return this.httpClient.post(this.BASE_URL+"/quiz/"+ quizId + "/questions",questionsList) ;
  }


  getAllQuestionsTypes()
  {
    return this.httpClient.get<QuestionType[]>(this.BASE_URL+"/lookup/questionType") ;
  }

  getQuizQuestions(quizID : number)
  {
     return this.httpClient.get<QuestionVto[]>(this.BASE_URL+"/quiz/" + quizID +"/questionsView") ;
  }

  createQuizClosure(courseID : number ,quizID : number , data : QuizDto){

    return this.httpClient.post(this.BASE_URL + "/quiz/" + courseID + quizID , data);

  }

}
