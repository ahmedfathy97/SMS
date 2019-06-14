import {Injectable} from "@angular/core";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {HttpClient} from "@angular/common/http";
import {QuizDto} from "../data/quiz/quiz-dto";
import {QuestionType} from "../data/quiz/question-type";
import {QuestionDto} from "../data/quiz/question-dto";
import {QuestionVto} from "../data/quiz/question-vto";
import {StudentAnswerDto} from "../data/quiz/student-answer-dto";
import {QuizInformationVto} from "../data/quiz/quiz-information-vto";
import {QuizResult} from "../data/quiz/quiz-result-dto";


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

  submitQuizAnswersForStudent( quizID :number , studentAnswerDTOList : StudentAnswerDto[]  )
  {
    return this.httpClient.post(this.BASE_URL + "/quiz/"  +"/" +quizID +"/answer" ,studentAnswerDTOList) ;
  }
  getQuizQuestions(quizID : number)
  {
     return this.httpClient.get<QuestionVto[]>(this.BASE_URL+"/quiz/" + quizID +"/questionsView") ;
  }

  createQuizClosure(courseID : number ,quizID : number , data : QuizDto){

    return this.httpClient.post(this.BASE_URL + "/quiz/" + courseID + quizID , data);

  }


  closeQuiz(quizID : number )
  {
    return this.httpClient.put( this.BASE_URL + "/quiz/"+ quizID +"/close" ,null) ;
  }

  getQuizDetails(quizID : number)
  {
    return this.httpClient.get<QuizInformationVto>(this.BASE_URL + "/quiz/" +quizID+"/quizDetails" )
  }


  getQuizResult(quizID : number )
  {
    return this.httpClient.get<QuizResult[]>(this.BASE_URL+"/quiz/"+quizID+"/results")
  }

  getQuizState(quizID : number)
  {
    return this.httpClient.get<number>(this.BASE_URL+"/quiz/"+quizID+"/state");

  }
}
