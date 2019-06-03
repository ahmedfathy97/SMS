package com.sms.controller;

import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.course.ExamInformationVTO;
import com.sms.model.course.quiz.*;
import com.sms.model.user.UserVTO;
import com.sms.service.ExamSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/exam")
public class ExamRes {
    private ExamSer examSer ;

    @Autowired
    public ExamRes(ExamSer examSer) {
        this.examSer = examSer;
    }


    @POST
    @Path("/{examID}/questions")
    @Consumes(MediaType.APPLICATION_JSON)
   // @Authenticated(actions = {AuthActions.COR_ADD_QUESTION})
    public void createExamQuestions(@PathParam("examID") int examID, List<QuestionDTO> questionList) {
        examSer.createExamQuestions(examID, questionList);
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{examID}/questionsView")
   // @Authenticated(views = {AuthViews.ANSWER_QUESTION})
    public List<QuestionVTO> getExamQuestions(@PathParam("examID") int examID) {
        List<QuestionVTO> questionsList = examSer.getExamQuestions(examID);
        return questionsList;
    }







    @POST
    @Path("/{examID}/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Authenticated(actions = {AuthActions.ANSWER_QUESTION})
    public  void submitExamAnswers(@Context ContainerRequestContext request, @PathParam("examID")int examID , List<StudentAnswerDTO> studentAnswerDTOList)
    {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        examSer.submitExamAnswers( currentUser.getId() ,examID , studentAnswerDTOList);
    }


    @PUT
    @Path("/{examID}/close")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Authenticated(actions = {AuthActions.CLOSE_QUIZ})
    public void closeExam (@PathParam("examID")int examID )
    {
        examSer.closeExam(examID);

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{examID}/Details")
    //@Authenticated(views = {AuthViews.MAIN_DETAILS})
    public ExamInformationVTO getExamInformation(@PathParam("examID")int examID)
    {
        return examSer.getExamInformation(examID) ;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{examID}/results")
    //@Authenticated(views = {AuthViews.QUIZ_RESULT})
    public List<QuizResult> getQuizResult(@Context ContainerRequestContext request, @PathParam("examID")int examID  )
    {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return examSer.getExamResult(currentUser.getId() ,examID) ;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{examID}/state")
    //@Authenticated(views = {AuthViews.QUIZ_DETAILS})
    public int quizState( @Context ContainerRequestContext request ,@PathParam("examID")int examID)
    {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return examSer.examState( currentUser ,examID) ;
    }




}
