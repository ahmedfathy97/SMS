package com.sms.repository;

import com.sms.model.course.QuestionDTO;
import com.sms.model.course.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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






}
