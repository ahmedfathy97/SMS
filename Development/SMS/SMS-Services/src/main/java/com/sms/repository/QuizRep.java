package com.sms.repository;

import com.sms.model.course.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuizRep {
    private JdbcTemplate jdbcTemplate ;
    @Autowired
    public QuizRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void insertNewQuiz( QuizDTO quizData)
    {
          String sql ="INSERT INTO quiz ( quiz_name, grade, due_date, course_id) VALUES (? ,? ,?,?);\n" ;
          this.jdbcTemplate.update(sql,quizData.getQuizName() ,quizData.getGrade() ,quizData.getDueDate() ,quizData.getCourseID());
    }
}
