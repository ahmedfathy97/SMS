
export enum AngularFullRoutes {
  COURSE_LIST = "/courses",
  // COURSE_HOME = "/course",
  COR_VIEW_ANNOUNCEMENT = "/course/${corID}/announcement",
  COR_NEW_ANNOUNCEMENT = "/course/${corID}/announcement/new",
  COR_CREATE_GRADE = "/course/${corID}/grade/new",
  COR_VIEW_GRADE = "/course/${corID}/grade",
  COR_NEW_QUIZ ="/course/${corID}/quiz/new" ,
  COR_VIEW_QUIZ ="/course/${corID}/quiz" ,
  COR_ANSWER_QUIZ ="/course/${corID}/quiz/${quizID}/answerQuiz" ,
  COR_NEW_Attendance = "/course/${corID}/attendance/new",
  COR_VIEW_Attendance = "/course/${corID}/attendance",
  COR_CREATE_LECTURE = "/course/${corID}/lecture/new",
  COR_VIEW_LECTURES = "/course/${corID}/lecture",



  FACULTY_LIST = "/faculties",
  SETTINGS = "/settings",
  SETTING_USER_LIST ="/settings/users",
  USER_PROFILE="/user/${userID}/profile",
  EDIT="/user/${userID}/edit"
}

export function replaceCorID(route:string, id) {
  return route.replace("${corID}", id);
}

export function replaceQuizID(route:string ,corID, quizID) {
  route = route.replace("${quizID}", quizID);
  return route.replace("${corID}", corID);

}
 export function replaceUserID(route:string,userID) {
  return route.replace("${userID}",userID);
 }
