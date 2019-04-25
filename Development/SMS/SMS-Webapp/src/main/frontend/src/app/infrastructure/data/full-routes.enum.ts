
export enum AngularFullRoutes {
  COURSE_LIST = "/courses",
  COURSE_HOME = "/course",
  COR_NEW_ANNOUNCEMENT = "/course/${corID}/announcment",



  FACULTY_LIST = "/faculties",



  SETTINGS = "/settings"
}

export function replaceCorID(route:string, id) {
  return route.replace("${corID}", id);
}
