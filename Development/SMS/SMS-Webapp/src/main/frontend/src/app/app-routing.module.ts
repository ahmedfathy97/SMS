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

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: SimpleLayoutComponent, children: [
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'home', component: HomeComponent} ,

      /////////////////////////////// Start  New Routing /////////////////////////////////////
      {
        path: 'course', /* component which view all courses*/ children: [
          {path: 'new', component: CreateCourse},
          {
            path: ':courseID'  , children: [
              {path: 'details', component: CourseDetailsComponent},
              // {
              //   path: 'lecture',component :CourseInfoComponent , children: [
              //     {path: 'new', component: CreateLecture},
              //     {
              //       path: ':lectureID', childern: [
              //         // {path:'dashboard' ,} ,
              //         {path: 'upload ', component: UploadComponent},
              //         {path: 'download', component: DownloadComponent},
              //
              //
              //         // {path:'article'} ,
              //         //
              //         //
              //         // {path: 'assigment', children:[
              //         //     {path: 'new' },
              //         //     {path: ':studentID'},
              //         //   ]
              //         // },
              //
              //
              //       ]
              //     },
              //   ]
              // },

              {
                path: 'attendance', children: [
                  {path: 'new', component: CreateAttendanceComponent},
                  {path: 'allStudentsAttendence', component: ViewAttendanceComponent},
                  {path: ':stdID', component: ViewStudentAttendanceComponent},
                ]
              },

              {
                path: 'grade', children: [
                  {path: 'new', component: CreateGradeComponent},
                  {path: 'allStudentsGrades', component: ViewGradeComponent},
                  {path: ':studentID /studentGrade', component: ViewStudentGradeComponent},
                ]
              },

              {
                path: 'quiz', children: [

                  {path: 'new', component: CreateQuizComponent},
                  {path: 'courseQuizes', component: CourseQuizesComponent},

                  {path: 'questions', component: AddQuizQuestionsComponent},
                  {
                    path: ':quizID', children: [
                      {path: ':studentID/answerQuiz', component: AnswerQuestionsComponent},

                    ]
                  },
                ]
              },

            ]
          },

        ]
      },
      /////////////////////////////// END New Routing /////////////////////////////////////
    ]
  },

  {path: '', component: FullLayoutComponent, children: [
      // {path: 'lecture', component: CreateLecture},
      // OLD ROUTING HALA
      // {path: 'create-grade', component: CreateGradeComponent},
      // {path: 'view-grade', component: ViewGradeComponent},
      // {path: 'std-grade', component: ViewStudentGradeComponent},

      // // OLD ROUTING ABANOUB
      // {path: 'attachment/file/upload', component: UploadComponent},
      // {path: 'attachment/file/download', component: DownloadComponent},
      //
      // //OLD ROUNTING YOUSEF
      // {path: 'course/new', component: CreateCourse},
      // {path: 'course/:corID', component: CourseInfoComponent},
      //
      // //OLD Routing Yara
      {path: 'attend', component: CreateAttendanceComponent},
      {path: 'view-attend', component: ViewAttendanceComponent},
      {path: 'view-student-attend', component: ViewStudentAttendanceComponent},
      // //{path: 'tutorials', component: TutorialsComponent},
      //
      // //OLD ROUTING Ahmed
      // {path: 'course/quiz/new', component: CreateQuizComponent},
      // {path: 'course/quiz/add_questions', component: AddQuizQuestionsComponent},
      // {path: 'course/quiz/answer_questions', component: AnswerQuestionsComponent},
      // {path: 'course/quizes', component: CourseQuizesComponent},
      // {path: 'course/:corID/course_details', component: CourseDetailsComponent},
      //
      //Manar
      {path: 'profile', children: [{path: ':userID', component: UserProfileComponent}]},

      {path:'edit',children:[{path:':userID',component:UserEditComponent}]},


    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
