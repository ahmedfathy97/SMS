package com.sms.repository;

import com.sms.model.course.ExamInformationVTO;
import com.sms.model.course.quiz.*;
import com.sms.model.course.quiz.rm.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ExamRep {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExamRep(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertNewQuestion(int examID, QuestionDTO questionData) {

        String sql = "INSERT INTO exam_question " +
                " (question, model_answer, answer1, answer2, answer3, answer4, exam_id ,exam_question_type_id ,question_grade) " +
                "VALUES (?,?,?,?,?,?,?,?,?);\n";
        this.jdbcTemplate.update(sql, questionData.getQuestion(), questionData.getModelAnswer(),
                questionData.getAnswer1(), questionData.getAnswer2(), questionData.getAnswer3(), questionData.getAnswer4(), examID, questionData.getQuestionTypeID(), questionData.getQuestionGrade());

    }


    public List<QuestionVTO> getExamQuestions(int examID) {
        String sql = "SELECT  id ,question ,exam_question_type_id," +
                " answer1 ,answer2 ,answer3 ,answer4  FROM exam_question" +
                " where exam_id = ? ;";

        List<QuestionVTO> examQuestions = this.jdbcTemplate.query(sql, new RowMapper<QuestionVTO>(){
            @Override
            public QuestionVTO mapRow(ResultSet rs, int i) throws SQLException {
                QuestionVTO questionVTO =new QuestionVTO() ;
                questionVTO.setId(rs.getInt("id"));
                questionVTO.setQuestion(rs.getString("question"));
                questionVTO.setQuestionTypeID(rs.getInt("exam_question_type_id"));
                questionVTO.setAnswer1(rs.getString("answer1"));
                questionVTO.setAnswer2(rs.getString("answer2"));
                questionVTO.setAnswer3(rs.getString("answer3"));
                questionVTO.setAnswer4(rs.getString("answer4"));
                return questionVTO ;
            }
        }, examID);
       return examQuestions ;
    }


//    public Date getCloseDate(int quizID) {
//
//        String sql = "select close_date from quiz where  id = ? ; ";
//        QuizDTO quizData = this.jdbcTemplate.queryForObject(sql, new QuizCloseDateRM(), quizID);
//        return quizData.getFinishDate();
//
//    }




    public List<ModelAnswerVTO> getQuestionsModelAnswer(int examID) {
        String sql = "SELECT id ,model_answer ,question_grade FROM exam_question where exam_id =? ;";
        List<ModelAnswerVTO> QuestionsModelAnswer = this.jdbcTemplate.query(sql, new RowMapper<ModelAnswerVTO>()
        {
            @Override
            public ModelAnswerVTO mapRow(ResultSet rs, int rowindex) throws SQLException {
                ModelAnswerVTO modelAnswerVTO =new ModelAnswerVTO() ;
                modelAnswerVTO.setQuestionID(rs.getInt("id"));
                modelAnswerVTO.setModelAnswer(rs.getString("model_answer"));
                modelAnswerVTO.setQuestionGrade(rs.getInt("question_grade"));
                return modelAnswerVTO;
            }
        }, examID) ;
        return QuestionsModelAnswer ;
    }


    public void submitQuestionAnswer(int studentID, int quizID, QuestionEvaluate questionEvaluate, StudentAnswerDTO studentAnswerDTO) {
        String sql = "INSERT INTO student_exam_answer " +
                "(student_id, exam_id, question_id, answer, is_correct ,student_score)" +
                " VALUES (?,?,?,?,?,?);\n";
        this.jdbcTemplate.update(sql, studentID, quizID, studentAnswerDTO.getQuestionID(), studentAnswerDTO.getStudentAnswer(), questionEvaluate.isCorrect(), questionEvaluate.getStudentGrade());
    }


    public void closeExam(int examID) {
        String sql = "UPDATE exam  SET is_closed ='1' WHERE id =?;";
        this.jdbcTemplate.update(sql, examID);
    }


    public ExamInformationVTO getExamInformation(int examID) {

        String sql = "SELECT exam_name , grade ,  " +
                "count(distinct user_id) AS numberofstudentanswers\n" +
                "FROM student_exam_answer sa Left join exam e\n" +
                "ON sa.exam_id = e.id \n" +
                "where e.id = ? ;";

        return this.jdbcTemplate.queryForObject(sql, new ExamInformationVTORM(), examID);

    }


    public boolean isExamOpen(int examID)
    {
        String sql ="SELECT is_closed FROM exam WHERE id = ? AND is_closed = 0" ;


        List<Object> results = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                return new Object();

            }
        }, examID);

        return results.size() !=0;
    }


    public List<QuizResult> getExamResult(int studentID , int examID )
    {
        String sql ="select q.question , q.answer1, q.answer2,\n" +
                "                q.answer3,q.answer4,q.model_answer ,q.exam_question_type_id, s.answer,s.is_correct, s.student_score\n" +
                "                from exam_question q left join student_exam_answer s on s.exam_id = q.exam_id\n" +
                "                and s.question_id = q.id \n" +
                "                where s.student_id = ? \n" +
                "                and q.exam_id = ? ; " ;

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
                result.setQuizQuestionTypeID(resultSet.getInt("exam_question_type_id"));
                result.setStudentAnswer(resultSet.getString("answer"));
                result.setCorrect(resultSet.getBoolean("is_correct"));
                result.setStudentGrade(resultSet.getInt("student_score"));

                return result ;

            }
        }, studentID , examID );

        return data;
    }

    public boolean  isAnswered(int studentID ,int examID)
    {
        String sql ="SELECT id FROM student_exam_answer WHERE student_id = ? AND exam_id =? " ;


        List<Object> results = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                return new Object();

            }
        }, studentID , examID);

        return results.size() !=0;
    }


    public boolean  examPutted(int examID)
    {
        String sql ="SELECT id FROM exam_question WHERE exam_id = ?  " ;


        List<Object> results = this.jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                return new Object();

            }
        }, examID);

        return results.size() !=0;
    }

}
