
export enum AngularFullRoutes {
  COURSE_LIST = "/courses",
  // COURSE_HOME = "/course",
  COR_VIEW_ANNOUNCEMENT = "/course/${corID}/announcement",
  COR_NEW_ANNOUNCEMENT = "/course/${corID}/announcement/new",



  FACULTY_LIST = "/faculties",



  SETTINGS = "/settings"
}

export function replaceCorID(route:string, id) {
  return route.replace("${corID}", id);
}
