import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {HomeComponent} from "./modules/home/home.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {LoginComponent} from "./modules/security/components/login/login.component";
import {CreateGradeComponent} from "./modules/course/components/course-details/course-content/grade/create-grade/create-grade.component";
import {CreateAttendanceComponent} from "./modules/course/components/course-details/course-content/attendance/create-attendance/create-attendance.component";
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {ViewAttendanceComponent} from "./modules/course/components/course-details/course-content/attendance/view-attendance/view-attendance.component";
import {CreateQuizComponent} from "./modules/course/components/course-details/course-content/quiz/create-quiz/create-quiz.component";
import {UserProfileComponent} from "./modules/user/components/user-profile/user-profile.component";
import {ViewGradeComponent} from "./modules/course/components/course-details/course-content/grade/view-grade/view-grade.component";
import {ViewStudentGradeComponent} from "./modules/course/components/course-details/course-content/grade/view-student-grade/view-student-grade.component";
import {ViewStudentAttendanceComponent} from "./modules/course/components/course-details/course-content/attendance/view-student-attendance/view-student-attendance.component";
import {AddQuizQuestionsComponent} from "./modules/course/components/course-details/course-content/quiz/add-quiz-questions/add-quiz-questions.component";
import {CreateLecture} from "./modules/course/components/course-details/course-content/lecture/create-lecture/create-lecture.component";

import {UploadComponent} from "./infrastructure/components/manage-attachment/components/upload/upload.component";
import {DownloadComponent} from "./infrastructure/components/manage-attachment/components/download/download.component";
import {AnswerQuestionsComponent} from "./modules/course/components/course-details/course-content/quiz/answer-questions/answer-questions.component";
import {UserEditComponent} from "./modules/user/components/user-edit/user-edit.component";
import {RegisterComponent} from "./modules/security/components/register/register.component";
import {CourseQuizesComponent} from "./modules/course/components/course-details/course-content/quiz/course-quizes/course-quizes.component";
import {CourseLecturesComponent} from "./modules/course/components/course-details/course-content/lecture/course-lectures/course-lectures.component";
import {CourseDetailsComponent} from "./modules/course/components/course-details/course-details.component";
import {CourseInfoComponent} from "./modules/course/components/course-details/course-content/course-info/course-info.component";
import {CreateAnnouncmentComponent} from "./modules/course/components/course-details/course-content/announcment/create-announcment/create-announcment.component";
import {CourseListComponent} from "./modules/course/components/course-list/course-list.component";
import {ViewAnnouncmentComponent} from "./modules/course/components/course-details/course-content/announcment/view-announcment/view-announcment.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: SimpleLayoutComponent, children: [
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'home', component: HomeComponent} ,
      {path: 'profile', children: [{path: ':userID', component: UserProfileComponent}]},
      {path:'edit',children:[{path:':userID',component:UserEditComponent}]} ,


      {path: 'course', /* component which view all courses*/ children: [

          {path: 'new', component: CreateCourse},
          {path: 'list', component: CourseListComponent},
          {path: ':courseID', component: CourseDetailsComponent, children: [
              {path:'',component:ViewAnnouncmentComponent} ,
               {path: 'announcment', component: CreateAnnouncmentComponent},
              {path: 'information', component: CourseInfoComponent},
              {path: 'lecture', children: [
                  {path:'' ,component: CourseLecturesComponent} ,
                  {path: 'new', component: CreateLecture}//,
                  // {path: ':lectureID', children: [
                  //     {path: 'upload ', component: UploadComponent},p
                  //     {path: 'download', component: DownloadComponent}
                  //   ]
                  // },
                ]
              },

              {path: 'attendance', children: [
                  {path: '', component: ViewAttendanceComponent},
                  {path: 'new', component: CreateAttendanceComponent}
                ]
              },

              {
                path: 'grade', children: [
                  {path: '', component: ViewGradeComponent},
                  {path: 'new', component: CreateGradeComponent}
                ]
              },

              {
                path: 'quiz', children: [
                  {path: '', component: CourseQuizesComponent},
                  {path: 'new', component: CreateQuizComponent},
                  {path: 'questions', component: AddQuizQuestionsComponent},
                  {path: ':quizID', children: [
                      {path: 'answerQuiz', component: AnswerQuestionsComponent},
                    ]
                  },
                ]
              },
            ]
          },
        ]
      }
    ]
  },

  {path: '', component: FullLayoutComponent, children: [
      {path: 'profile', children: [{path: ':userID', component: UserProfileComponent}]},
      {path:'edit',children:[{path:':userID',component:UserEditComponent}]}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
