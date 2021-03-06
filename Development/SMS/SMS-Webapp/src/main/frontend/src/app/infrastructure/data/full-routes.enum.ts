
export enum AngularFullRoutes {
  LOGIN = "/login",
  REGISTER = "/register",
  HOME = "/home",
  COURSE_LIST = "/courses",
  // COURSE_HOME = "/course",
  // _COURSE_LIST="/courses",
  MY_COURSES="/my-courses",
  COR_VIEW_ANNOUNCEMENT = "/course/${corID}/announcement",
  COR_NEW_ANNOUNCEMENT = "/course/${corID}/announcement/new",
  COR_CREATE_GRADE = "/course/${corID}/grade/new",
  COR_VIEW_GRADE = "/course/${corID}/grade",
  COR_VIEW_QUIZ_GRADES = "/course/${corID}/grade/quizes",
  COR_NEW_QUIZ ="/course/${corID}/quiz/new" ,
  COR_VIEW_QUIZ ="/course/${corID}/quiz" ,
  COR_VIEW_QUIZ_DETAILS = "/course/${corID}/quiz/${quizID}/quizDetails" ,
  COR_VIEW_QUIZ_QUESTIONS="/course/${corID}/quiz/${quizID}/answerQuiz" ,
  COR_VIEW_EXAM ="/course/${corID}/exam" ,
  COR_VIEW_EXAM_DETAILS ="/course/${corID}/exam/${examID}/examDetails" ,
  COR_NEW_Attendance = "/course/${corID}/attendance/new",
  COR_VIEW_Attendance = "/course/${corID}/attendance",
  COR_CREATE_LECTURE = "/course/${corID}/lecture/new",
  COR_VIEW_LECTURES = "/course/${corID}/lecture",
  COR_LECTURE = "/course/${corID}/lecture/${lectureID}",
  COR_CREATE = "/course/new",
  COR_LECTURE_MATERIALS = "/course/${corID}/lecture/${lectureID}/upload",
  WELCOME = "/home",
  FACULTY_LIST = "/faculties",
  SETTINGS = "/settings",
  SETTING_USER_LIST ="/settings/users",
  USER_PROFILE="/user/${userID}/profile",
  EDIT="/user/${userID}/edit",
  COURSE_INFORMATION = "/course/${corID}/information",
  COR_LECTURE_ASSIGNMENTS = "/course/${corID}/lecture/${lectureID}/assignment",

}

export function replaceCorID(route:string, id) {
  return route.replace("${corID}", id);
}

export function replaceQuizID(route:string ,corID, quizID) {
  route = route.replace("${quizID}", quizID);
  return route.replace("${corID}", corID);

}
export function replaceExamID(route:string ,corID, examID) {
  route = route.replace("${examID}", examID);
  return route.replace("${corID}", corID);

}
 export function replaceUserID(route:string,userID) {
  return route.replace("${userID}",userID);
 }

export function replaceLecID(route:string, corID, lectureID) {
  route = route.replace("${lectureID}", lectureID);
  return route.replace("${corID}", corID);
}
