package com.sms.model.authorization;

public enum AuthViews {
    USER_LIST(1),
    ADD_GRADE(2),
    ADD_ATTENDANCE(3),
    ADD_ANNOUNCEMENT(4),
    USER_PROFILE(5),
    USER_EDIT(6),
    ADD_MATERIAL(7),
    ADD_COR(8) ,
    ADD_LEC(9),
    COURSE_QUIZES (10) ,
    CREATE_QUIZ (11),
    ADD_QUESTION(12),
    ANSWER_QUESTION(13),
    QUIZ_DETAILS(14),
    MAIN_DETAILS (15) ,
    QUIZ_RESULT(16),
    LECTURE_DETAILS(17),
    COURSE_LECTURES(18),
    ADD_EXAM_QUESTION(19),
    ANSWER_EXAM_QUESTION(20),
    EXAM_DETAILS(21),
    EXAM_MAIN_DETAILS (22) ,
    EXAM_RESULT(23) ,
    COURSE_EXAMS(24),
    COURSE_LIST(25),
    MY_COURSE(26);


    private int id;

    AuthViews(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
