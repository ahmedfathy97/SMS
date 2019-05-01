package com.sms.repository;

import com.sms.controller.filter.AuthenticationFilter;
import com.sms.model.course.StdDTO;
import com.sms.model.course.quiz.*;
import com.sms.model.course.quiz.rm.ModelAnswerVTORM;
import com.sms.model.course.quiz.rm.QuizCloseDateRM;
import com.sms.model.course.quiz.rm.QuestionVTORM;
import com.sms.model.course.quiz.rm.QuizInformationVTORM;
import com.sms.model.user.UserVTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        String sql = "SELECT quiz_name , grade ,start_date , close_date ,  " +
                "count(distinct user_id) AS numberofstudentanswers\n" +
                "FROM student_answer sa Left join quiz q\n" +
                "ON sa.quiz_id = q.id \n" +
                "where q.id = ? ;";

        return this.jdbcTemplate.queryForObject(sql, new QuizInformationVTORM(), quizID);

    }


    public boolean isQuizOpen(int quizID)
    {
        String sql ="SELECT is_closed FROM quiz WHERE id = ? AND is_closed = 0" ;


        List<Object> results = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                return new Object();

            }
        }, quizID);

        return results.size() !=0;
    }


    public List<QuizResult> getQuizResult ( int studentID ,int quizID )
    {
        String sql ="select q.question , q.answer1, q.answer2,\n" +
                "                q.answer3,q.answer4,q.model_answer ,q.quiz_question_type_id, s.answer,s.is_correct, s.student_score\n" +
                "                from question q left join student_answer s on s.quiz_id = q.quiz_id\n" +
                "                and s.question_id = q.id \n" +
                "                where s.user_id = ? \n" +
                "                and q.quiz_id = ? ; " ;

        List<QuizResult> data = this.jdbcTemplate.query(sql, new RowMapper<QuizResult>() {
            @Override
            public QuizResult mapRow(ResultSet resultSet, int i) throws SQLException {
                QuizResult result = new QuizResult() ;
                result.setQuestion(resultSet.getString("question"));
                result.setAnswer1(resultSet.getString("answer1"));
                result.setAnswer2(resultSet.getString("answer2"));
                result.setAnswer3(resultSet.getString("answer3"));
                result.setAnswer4(resultSet.getString("answer4"));
                result.setModelAnswer(resultSet.getString("model_answer"));
                result.setQuizQuestionTypeID(resultSet.getInt("quiz_question_type_id"));
                result.setStudentAnswer(resultSet.getString("answer"));
                result.setCorrect(resultSet.getBoolean("is_correct"));
                result.setStudentGrade(resultSet.getInt("student_score"));

                return result ;

            }
        }, studentID , quizID );

        return data;
    }

    public boolean  isAnswered(int studentID ,int quizID)
    {
        String sql ="SELECT id FROM student_answer WHERE user_id = ? AND quiz_id =? " ;


        List<Object> results = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                return new Object();

            }
        }, studentID , quizID);

        return results.size() !=0;
    }


}
