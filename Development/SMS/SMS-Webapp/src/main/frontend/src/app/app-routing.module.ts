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
import {UserProfileComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-content/user-profile/user-profile.component";
import {ViewGradeComponent} from "./modules/course/components/course-details/course-content/grade/view-grade/view-grade.component";
import {AddQuizQuestionsComponent} from "./modules/course/components/course-details/course-content/quiz/add-quiz-questions/add-quiz-questions.component";
import {CreateLecture} from "./modules/course/components/course-details/course-content/lecture/create-lecture/create-lecture.component";

import {UploadComponent} from "./infrastructure/components/manage-attachment/components/upload/upload.component";
import {DownloadComponent} from "./infrastructure/components/manage-attachment/components/download/download.component";
import {AnswerQuestionsComponent} from "./modules/course/components/course-details/course-content/quiz/quiz-details/answer-questions/answer-questions.component";
import {UserEditComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-content/user-edit/user-edit.component";
import {RegisterComponent} from "./modules/security/components/register/register.component";
import {CourseQuizesComponent} from "./modules/course/components/course-details/course-content/quiz/course-quizes/course-quizes.component";
import {CourseLecturesComponent} from "./modules/course/components/course-details/course-content/lecture/course-lectures/course-lectures.component";
import {CourseDetailsComponent} from "./modules/course/components/course-details/course-details.component";
import {CourseInfoComponent} from "./modules/course/components/course-details/course-content/course-info/course-info.component";
import {CreateAnnouncmentComponent} from "./modules/course/components/course-details/course-content/announcment/create-announcment/create-announcment.component";
import {ViewAnnouncmentComponent} from "./modules/course/components/course-details/course-content/announcment/view-announcment/view-announcment.component";
import {LectureDetailsComponent} from "./modules/course/components/course-details/course-content/lecture/lecture-details/lecture-details.component";
import {UserListComponent} from "./modules/settings/components/setting-content/user/component/user-list/user-list.component";
import {SettingDetailsComponent} from "./modules/settings/components/setting-details/setting-details.component";
import {UserDetailComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-detail.component";
import {AuthViews} from "./infrastructure/directives/authorization/data/auth-views.enum";
import {AuthorizationGuard} from "./infrastructure/interceptor/authorization.guard";
import {AuthenticationGuard} from "./infrastructure/interceptor/authentication.guard";
import {CourseListComponent} from "./modules/course/components/course-list/course-list.component";
import {MyCourseComponent} from "./modules/course/components/my-course/my-course.component";
import {QuizDetailsComponent} from "./modules/course/components/course-details/course-content/quiz/quiz-details/quiz-details.component";
import {CourseExamsComponent} from "./modules/course/components/course-details/course-content/exam/course-exams/course-exams.component";
import {AddExamQuestionsComponent} from "./modules/course/components/course-details/course-content/exam/add-exam-questions/add-exam-questions.component";
import {ExamDetailsComponent} from "./modules/course/components/course-details/course-content/exam/exam-details/exam-details.component";
import {AnswerExamQuestionsComponent} from "./modules/course/components/course-details/course-content/exam/exam-details/answer-exam-questions/answer-exam-questions.component";
import {QuizGradeComponent} from "./modules/course/components/course-details/course-content/quiz-grade/quiz-grade.component";
import {LoginGuard} from "./infrastructure/interceptor/login.guard";
import {AssignmentDetailsComponent} from "./modules/course/components/course-details/course-content/lecture/lecture-details/assignment-details/assignment-details.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {
    path: '', component: SimpleLayoutComponent, children: [
      {path: 'login', canActivate:[LoginGuard], component: LoginComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'home', component: HomeComponent},
      {
        path: 'user', children: [
          {
            path: ':userID', component: UserDetailComponent, children: [
              {path: 'profile', component: UserProfileComponent,data: {viewID: AuthViews.USER_PROFILE},
                canActivate:[AuthenticationGuard, AuthorizationGuard]},
              {path: 'edit', component: UserEditComponent,data: {viewID: AuthViews.USER_EDIT},
                canActivate:[AuthenticationGuard, AuthorizationGuard]}
            ]
          },

        ]
      } ,

      {path:'settings',children:
          [
            {path:'',component:SettingDetailsComponent ,children:[
                {path:'users',component:UserListComponent, data: {viewID: AuthViews.USER_LIST},
                  canActivate:[AuthenticationGuard, AuthorizationGuard]},
                {path: 'user', children: [
                    {path: ':userID', component: UserProfileComponent,data: {viewID: AuthViews.USER_PROFILE},
                      canActivate:[AuthenticationGuard, AuthorizationGuard]}
                  ]}
              ]} ,
          ]
      },


      /* for some purposes  */
      {path: 'lecture', component: LectureDetailsComponent},
      {path: 'upload', component: UploadComponent},
      {path: 'download', component: DownloadComponent},

      {path: '', component: FullLayoutComponent, children: [
          {path: 'courses', component: CourseListComponent },
          {path: 'course/new', component: CreateCourse ,
            data: {viewID: AuthViews.ADD_LEC},
            canActivate:[AuthenticationGuard, AuthorizationGuard]},
          // {path: 'profile', children: [{path: ':userID', component: UserProfileComponent}]},
          {path: 'my-courses', component: MyCourseComponent , data: {viewID: AuthViews.MY_COURSE} ,
            canActivate:[AuthenticationGuard, AuthorizationGuard]},
          {path: 'courses', component: CourseListComponent, data: {viewID: AuthViews.COURSE_LIST} ,
            canActivate:[AuthenticationGuard, AuthorizationGuard]},

          // {path: 'profile', children: [{path: ':userID', component: UserProfileComponent}]},
          // {path:'edit',children:[{path:':userID',component:UserEditComponent}]}
        ] } ,


      {
        path: 'course', /* component which view all courses*/ children: [
          {path: ':courseID', component: CourseDetailsComponent, children: [
              {
                path: 'announcement', children: [
                  {path: '', component: ViewAnnouncmentComponent},
                  {path: 'new', component: CreateAnnouncmentComponent , data: {viewID: AuthViews.ADD_ANNOUNCEMENT} ,
                    canActivate:[AuthenticationGuard, AuthorizationGuard] }
                ]
              },
              {path: 'information', component: CourseInfoComponent},
              {
                path: 'lecture', children: [
                  {path: '', component: CourseLecturesComponent, data: {viewID: AuthViews.COURSE_LECTURES},
                    canActivate:[AuthenticationGuard, AuthorizationGuard]},
                  {path: 'new', component: CreateLecture ,
                    data: {viewID: AuthViews.ADD_COR}, canActivate:[AuthenticationGuard, AuthorizationGuard]},
                  {
                    path: ':lectureID',
                    data: {viewID: AuthViews.LECTURE_DETAILS},
                    canActivate: [AuthenticationGuard, AuthorizationGuard], children: [
                      {path: '', component: LectureDetailsComponent},
                      {
                        path: 'assignment',
                        component: AssignmentDetailsComponent,
                        data: {viewID: AuthViews.COURSE_LECTURES},
                        canActivate: [AuthenticationGuard, AuthorizationGuard]
                      },
                      {path: 'upload', component: UploadComponent},
                    ]

                  },
                ]
              },
              {
                path: 'attendance', children: [
                  {
                    path: '', component: ViewAttendanceComponent, data: {viewID: AuthViews.ADD_ATTENDANCE},
                    canActivate: [AuthenticationGuard, AuthorizationGuard]
                  },
                  {
                    path: 'new', component: CreateAttendanceComponent, data: {viewID: AuthViews.ADD_ATTENDANCE},
                    canActivate: [AuthenticationGuard, AuthorizationGuard]
                  }
                ]
              },

                  {
                    path: 'grade', children: [
                      {path: '', component: ViewGradeComponent},
                      {path: 'new', component: CreateGradeComponent,data: {viewID: AuthViews.ADD_GRADE},
                        canActivate:[AuthenticationGuard, AuthorizationGuard]},
                      {path: 'quizes', component: QuizGradeComponent},

                      // {path:'edit/:stdID', component:CreateGradeComponent}
                    ]
                  },

              {
                path: 'quiz', children: [
                  {path: '', component: CourseQuizesComponent ,data: {viewID: AuthViews.COURSE_QUIZES},
                    canActivate:[AuthenticationGuard, AuthorizationGuard]},
                  {path: 'new', component: CreateQuizComponent , data: {viewID: AuthViews.CREATE_QUIZ},
                    canActivate:[AuthenticationGuard, AuthorizationGuard]},
                  {
                    path: ':quizID', children: [
                      {path: 'questions', component: AddQuizQuestionsComponent , data: {viewID: AuthViews.ADD_QUESTION},
                        canActivate:[AuthenticationGuard, AuthorizationGuard]},
                       {path: 'answerQuiz', component: AnswerQuestionsComponent ,data: {viewID: AuthViews.ANSWER_QUESTION},
                         canActivate:[AuthenticationGuard, AuthorizationGuard]},
                      {path: 'quizDetails', component: QuizDetailsComponent,data: {viewID: AuthViews.QUIZ_DETAILS},
                        canActivate:[AuthenticationGuard, AuthorizationGuard]},

                        ]
                      },
                    ]
                  },
              {
                path: 'exam', children: [
                  {path: '', component: CourseExamsComponent ,data: {viewID: AuthViews.COURSE_EXAMS},
                    canActivate:[AuthenticationGuard, AuthorizationGuard]},
                  {
                    path: ':examID', children: [
                      {path: 'questions', component: AddExamQuestionsComponent ,data: {viewID: AuthViews.ADD_EXAM_QUESTION},
                        canActivate:[AuthenticationGuard, AuthorizationGuard]} ,
                      {path: 'answerExam', component: AnswerExamQuestionsComponent ,data: {viewID: AuthViews.ANSWER_EXAM_QUESTION},
                        canActivate:[AuthenticationGuard, AuthorizationGuard]},
                      {path: 'examDetails', component: ExamDetailsComponent ,data: {viewID: AuthViews.EXAM_DETAILS},
                        canActivate:[AuthenticationGuard, AuthorizationGuard]},

                    ]
                  },
                ]
              },
                ]
              },
            ]
          }
        ]
      }
    ]

    @NgModule({
      imports: [RouterModule.forRoot(routes)],
      exports: [RouterModule]
    })
    export class AppRoutingModule {
    }
