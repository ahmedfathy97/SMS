
export enum AngularFullRoutes {
  COURSE_LIST = "/courses",
  // COURSE_HOME = "/course",
  COR_VIEW_ANNOUNCEMENT = "/course/${corID}/announcement",
  COR_NEW_ANNOUNCEMENT = "/course/${corID}/announcement/new",
  COR_NEW_QUIZ ="/course/${corID}/quiz/new" ,
  COR_VIEW_QUIZ ="/course/${corID}/quiz" ,
  COR_ADD_QUIZ_QUISTIONS = "/course/${corID}/quiz/${quizID}/questions" ,
  COR_NEW_Attendance = "/course/${corID}/attendance/new",
  COR_VIEW_Attendance = "/course/${corID}/attendance",

  FACULTY_LIST = "/faculties",



  SETTINGS = "/settings"
}

export function replaceCorID(route:string, id) {
  return route.replace("${corID}", id);
}

export function replaceQuizID(route:string ,id) {
  return route.replace("${quizID}", id)

}
