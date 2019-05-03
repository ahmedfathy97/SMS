package com.sms.controller;

import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.annotation.Authenticated;
import com.sms.model.authorization.AuthActions;
import com.sms.model.authorization.AuthViews;
import com.sms.model.course.quiz.*;
import com.sms.model.user.UserVTO;
import com.sms.repository.QuizRep;
import com.sms.service.QuizSer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/quiz")
public class QuizRes {
    private QuizSer quizSer;
    private QuizRep repository;

    @Autowired
    public QuizRes(QuizSer quizSer, QuizRep repository) {
        this.quizSer = quizSer;
        this.repository = repository;
    }


    @POST
    @Path("/{quizID}/questions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Authenticated(actions = {AuthActions.COR_ADD_QUESTION})
    public void createQuizQuestions(@PathParam("quizID") int quizID, List<QuestionDTO> questionList) {
        quizSer.createQuizQuestions(quizID, questionList);
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{quizID}/questionsView")
    @Authenticated(views = {AuthViews.ANSWER_QUESTION})
    public List<QuestionVTO> getQuizQuestions(@PathParam("quizID") int quizID) {
        List<QuestionVTO> questionsList = quizSer.getQuizQuestions(quizID);
        return questionsList;
    }


    @POST
    @Path("/{quizID}/closeQuiz")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createQuizClosure(@PathParam("quizID") int quizID) {
        quizSer.createQuizClosure(quizID);
    }




    @POST
    @Path("/{quizID}/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Authenticated(actions = {AuthActions.ANSWER_QUESTION})
    public  void submitQuizAnswers(@Context ContainerRequestContext request, @PathParam("quizID")int quizID , List<StudentAnswerDTO> studentAnswerDTOList)
     {
         UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
         quizSer.submitQuizAnswers( currentUser.getId() ,quizID , studentAnswerDTOList);
     }


    @POST
    @Path("/{quizID}/close")
    @Consumes(MediaType.APPLICATION_JSON)
    public void closeQuiz (int quizID)
    {
        quizSer.closeQuiz(quizID);

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{quizID}/quizDetails")
    @Authenticated(views = {AuthViews.MAIN_DETAILS})
    public QuizInformationVTO getQuizInformation(@PathParam("quizID")int quizID)
    {
        return quizSer.getQuizInformation(quizID) ;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{quizID}/results")
    @Authenticated(views = {AuthViews.QUIZ_RESULT})
    public List<QuizResult> getQuizResult(@Context ContainerRequestContext request, @PathParam("quizID")int quizID  )
    {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return quizSer.getQuizResult(currentUser.getId() ,quizID) ;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{quizID}/state")
    @Authenticated(views = {AuthViews.QUIZ_DETAILS})
    public int quizState(@PathParam("quizID")int quizID, @Context ContainerRequestContext request)
    {
        UserVTO currentUser = (UserVTO) request.getProperty(AuthenticationFilter.AUTH_USER);
        return quizSer.quizState( currentUser ,quizID) ;
    }




}
