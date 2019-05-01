package com.sms.model.authorization;

public enum AuthViews {
    USER_LIST(1),
    ADD_GRADE(2),
    ADD_ATTENDANCE(3),
    ADD_ANNOUNCEMENT(4),
    CREATE_LEC(9),
    COURSE_QUIZES (10) ,
    CREATE_QUIZ (11),
    ADD_QUESTION(12),
    ANSWER_QUESTION(13),
    QUIZ_DETAILS(14);
    private int id;

    AuthViews(int id){
        this.id = id;
    }

    public int getID(){ return id; }
}
