import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {HomeComponent} from "./modules/home/home.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {LoginComponent} from "./modules/security/components/login/login.component";
import {CreateGradeComponent} from "./modules/course/components/grade/create-grade/create-grade.component";
import {CreateAttendanceComponent} from "./modules/course/components/attendance/create-attendance/create-attendance.component";
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {ViewCourseComponent} from "./modules/course/components/view-course/view-course.component";
import {ViewAttendanceComponent} from "./modules/course/components/attendance/view-attendance/view-attendance.component";
import {CreateQuizComponent} from "./modules/course/components/quiz/create-quiz/create-quiz.component";
import {UserProfileComponent} from "./modules/user/components/user-profile/user-profile.component";
import {ViewGradeComponent} from "./modules/course/components/grade/view-grade/view-grade.component";
import {ViewStudentGradeComponent} from "./modules/course/components/grade/view-student-grade/view-student-grade.component";
import {ViewStudentAttendanceComponent} from "./modules/course/components/attendance/view-student-attendance/view-student-attendance.component";
import {AddQuizQuestionsComponent} from "./modules/course/components/quiz/add-quiz-questions/add-quiz-questions.component";
//import {TutorialsComponent} from "./modules/course/components/tutorials/tutorials.component";
import {CreateLecture} from "./modules/course/components/create-lecture/create-lecture.component";

import {UploadComponent} from "./infrastructure/components/manage-attachment/components/upload/upload.component";
import {DownloadComponent} from "./infrastructure/components/manage-attachment/components/download/download.component";
import {AnswerQuestionsComponent} from "./modules/course/components/quiz/answer-questions/answer-questions.component";
import {ViewCourseQuizesComponent} from "./modules/course/components/quiz/view-course-quizes/view-course-quizes.component";
import {CourseDetailsComponent} from "./modules/course/components/course-details/course-details.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: FullLayoutComponent, children:[
      {path: 'lecture', component: CreateLecture},
      // OLD ROUTING HALA
      {path: 'create-grade', component: CreateGradeComponent},
      {path:'view-grade', component: ViewGradeComponent},
      {path:'std-grade',component:ViewStudentGradeComponent},

      // OLD ROUTING ABANOUB
      {path:'attachment/file/upload', component: UploadComponent},
      {path:'attachment/file/download', component: DownloadComponent},

      //OLD ROUNTING YOUSEF
      {path:'course/new', component: CreateCourse},
      {path:'course/:corID', component: ViewCourseComponent},

      //OLD Routing Yara
      {path: 'attend', component: CreateAttendanceComponent},
      {path: 'view-attend', component: ViewAttendanceComponent},
      {path: 'view-student-attend', component: ViewStudentAttendanceComponent},
      //{path: 'tutorials', component: TutorialsComponent},

      //OLD ROUTING Ahmed
      {path:'course/quiz/new',component:CreateQuizComponent} ,
      {path:'course/quiz/add_questions',component:AddQuizQuestionsComponent} ,
      {path:'course/quiz/answer_questions',component:AnswerQuestionsComponent} ,
      {path:'course/quizes',component:ViewCourseQuizesComponent} ,
      {path:'course/:corID/course_details' ,component:CourseDetailsComponent} ,

      //Manar
      {path:'profile',children:[{path:':userID',component:UserProfileComponent}]},

      {path: 'home', component: HomeComponent},
      /////////////////////////////// Start  New Routing /////////////////////////////////////
      {path: 'course',/* component which view all courses*/ children:[
          {path: 'new', component: CreateCourse},
          {path: ':corID', component: ViewCourseComponent , children:[
              {path: 'attendance', component: ViewAttendanceComponent , children:[
                  {path: 'new', component: CreateAttendanceComponent},
                  {path: ':stdID', component: ViewStudentAttendanceComponent},
                ]
              },
              {path: 'grade', component: ViewGradeComponent , children:[
                  {path: 'new', component: CreateGradeComponent},
                  {path: ':stdID', component: ViewStudentGradeComponent},
                ]},

              {path: 'quiz', /* component which view course's quiz*/ children:[
                  {path: 'new', component: CreateQuizComponent},
                  {path: ':quizID',/* component which view course's quiz with quizID*/ children:[
                      {path: 'questions', component: AddQuizQuestionsComponent},

                    ]},
                ]},

            ]},

        ]},
      /////////////////////////////// END New Routing /////////////////////////////////////

    ]},
  {path: '', component: SimpleLayoutComponent, children:[
      {path: 'login', component: LoginComponent},

    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
