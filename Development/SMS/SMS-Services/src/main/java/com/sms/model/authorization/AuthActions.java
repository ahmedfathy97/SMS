package com.sms.model.authorization;

public enum AuthActions {
    COR_ADD_GRADE(1),
    COR_ADD_ATTENDANCE(3),
    COR_ADD_ANNOUNCEMENT(4),
    ADD_LEC(7),
    ADD_COR(12),


    ENROLL_STUDENT(5),
    COURSE_QUIZES (10) ,
    CREATE_QUIZ (11),
    COR_ADD_QUESTION(12),
    ANSWER_QUESTION(13),
    QUIZ_DETAILS(14);
    private int id;

    AuthActions(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
