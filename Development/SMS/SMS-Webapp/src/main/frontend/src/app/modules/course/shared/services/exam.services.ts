import {Injectable} from "@angular/core";
import {QuizDto} from "../data/quiz/quiz-dto";
import {QuestionType} from "../data/quiz/question-type";
import {QuizInformationVto} from "../data/quiz/quiz-information-vto";
import {StudentAnswerDto} from "../data/quiz/student-answer-dto";
import {QuestionDto} from "../data/quiz/question-dto";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {QuizResult} from "../data/quiz/quiz-result-dto";
import {QuestionVto} from "../data/quiz/question-vto";
import {HttpClient} from "@angular/common/http";
import {ExamInformationVto} from "../data/quiz/exam-information-vto";

@Injectable()
export class ExamServices {
  BASE_URL: string = ConfigParam.APP_BASE_URL ;


  constructor(private httpClient: HttpClient) {
  }


  createExamQuestions(examID: number ,questionsList:QuestionDto[])
  {
    return this.httpClient.post(this.BASE_URL+"/exam/"+ examID + "/questions",questionsList) ;
  }


  submitExamAnswersForStudent( examID :number , studentAnswerDTOList : StudentAnswerDto[]  )
  {
    return this.httpClient.post(this.BASE_URL + "/exam/"  +"/" +examID +"/answer" ,studentAnswerDTOList) ;
  }
  getExamQuestions( examID : number)
  {
    return this.httpClient.get<QuestionVto[]>(this.BASE_URL+"/exam/" + examID +"/questionsView") ;
  }

  // createQuizClosure(courseID : number ,examID : number , data : QuizDto){
  //
  //   return this.httpClient.post(this.BASE_URL + "/exam/" + courseID + examID , data);
  //
  // }


  closeExam(examID : number )
  {
    return this.httpClient.put( this.BASE_URL + "/exam/"+ examID +"/close" ,null) ;
  }

  getExamDetails(examID : number)
  {
    return this.httpClient.get<ExamInformationVto>(this.BASE_URL + "/exam/" +examID+"/Details" )
  }


  getExamResult(examID : number )
  {
    return this.httpClient.get<QuizResult[]>(this.BASE_URL+"/exam/"+examID+"/results")
  }

  getExamState(examID : number)
  {
    return this.httpClient.get<number>(this.BASE_URL+"/exam/"+examID+"/state");

  }
}
