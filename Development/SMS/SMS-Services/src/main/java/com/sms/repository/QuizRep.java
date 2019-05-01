package com.sms.repository;

import com.sms.model.course.quiz.*;
import com.sms.model.course.quiz.rm.ModelAnswerVTORM;
import com.sms.model.course.quiz.rm.QuizCloseDateRM;
import com.sms.model.course.quiz.rm.QuestionVTORM;
import com.sms.model.course.quiz.rm.QuizInformationVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class QuizRep {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuizRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertNewQuestion(int quizID, QuestionDTO questionData) {

        String sql = "INSERT INTO question " +
                " (question, model_answer, answer1, answer2, answer3, answer4, quiz_id ,quiz_question_type_id ,question_grade) " +
                "VALUES (?,?,?,?,?,?,?,?,?);\n";
        this.jdbcTemplate.update(sql, questionData.getQuestion(), questionData.getModelAnswer(),
                questionData.getAnswer1(), questionData.getAnswer2(), questionData.getAnswer3(), questionData.getAnswer4(), quizID, questionData.getQuestionTypeID(), questionData.getQuestionGrade());

    }


    public List<QuestionVTO> getQuizQuestions(int quizID) {
        String sql = "SELECT  id ,question ,quiz_question_type_id," +
                " answer1 ,answer2 ,answer3 ,answer4  FROM question" +
                " where quiz_id = ? ;";

        return this.jdbcTemplate.query(sql, new QuestionVTORM(), quizID);

    }


    public Date getCloseDate(int quizID) {

        String sql = "select close_date from quiz where  id = ? ; ";
        QuizDTO quizData = this.jdbcTemplate.queryForObject(sql, new QuizCloseDateRM(), quizID);
        return quizData.getFinishDate();

    }

    public void createQuizClosure(int quizID) {

        String sql = "update quiz set close_auto = true \n" +
                "where id = ? ;";

        this.jdbcTemplate.update(sql, quizID);

    }


    public List<ModelAnswerVTO> getQuestionsModelAnswer(int quizID) {
        String sql = "SELECT id ,model_answer ,question_grade FROM question where quiz_id =? ;";
        return this.jdbcTemplate.query(sql, new ModelAnswerVTORM(), quizID);
    }


    public void submitQuestionAnswer(int studentID, int quizID, QuestionEvaluate questionEvaluate, StudentAnswerDTO studentAnswerDTO) {
        String sql = "INSERT INTO student_answer " +
                "(user_id, quiz_id, question_id, answer, is_correct ,student_score)" +
                " VALUES (?,?,?,?,?,?);\n";
        this.jdbcTemplate.update(sql, studentID, quizID, studentAnswerDTO.getQuestionID(), studentAnswerDTO.getStudentAnswer(), questionEvaluate.isCorrect(), questionEvaluate.getStudentGrade());
    }


    public void closeQuiz(int quizID) {
        String sql = "UPDATE quiz  SET is_closed ='1' WHERE id =?;";
        this.jdbcTemplate.update(sql, quizID);
    }


    public QuizInformationVTO getQuizInformation(int quizID) {

        String sql = "SELECT quiz_name , grade ,start_date , close_date ,  count(distinct user_id) AS numberofstudentanswers\n" +
                "FROM student_answer sa Left join quiz q\n" +
                "ON sa.quiz_id = q.id \n" +
                "where q.id = ? ;";

        return this.jdbcTemplate.queryForObject(sql, new QuizInformationVTORM(), quizID);

    }





}
