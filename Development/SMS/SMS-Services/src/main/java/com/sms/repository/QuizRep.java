package com.sms.repository;

import com.sms.model.course.QuestionDTO;
import com.sms.model.course.QuestionVTO;
import com.sms.model.course.QuizDTO;
import com.sms.model.course.rm.QuizDTORM;
import com.sms.model.course.rm.QuestionVTORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class QuizRep {
    private JdbcTemplate jdbcTemplate ;
    @Autowired
    public QuizRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertNewQuestion(int quizID , QuestionDTO questionData)
    {

        String sql ="INSERT INTO question " +
                " (question, model_answer, answer1, answer2, answer3, answer4, quiz_id ,quiz_question_type_id) " +
                "VALUES (?,?,?,?,?,?,?,?);\n" ;
        this.jdbcTemplate.update(sql,questionData.getQuestion() ,questionData.getModelAnswer(),
                questionData.getAnswer1(),questionData.getAnswer2(),questionData.getAnswer3(),questionData.getAnswer4(),quizID ,questionData.getQuestionTypeID()) ;

    }


    public List<QuestionVTO> getQuizQuestions(int quizID)
    {
       String sql ="SELECT id ,question ,quiz_question_type_id," +
               " answer1 ,answer2 ,answer3 ,answer4 FROM question" +
               " where quiz_id = ? ;" ;

       return this.jdbcTemplate.query(sql ,new QuestionVTORM() ,quizID) ;

    }


    public Date getCloseDate (int quizID) {

        String sql = "select close_date from quiz where  id = ? ; " ;
        QuizDTO quizData = this.jdbcTemplate.queryForObject(sql ,new QuizDTORM(), quizID);
        return quizData.getFinishDate() ;

    }

    public void createQuizClosure (int quizID){

        String sql = "update quiz set close_auto = true \n" +
                "where id = ? ;" ;

        this.jdbcTemplate.update(sql, quizID ) ;

    }

}
