import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {HomeComponent} from "./modules/home/home.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {LoginComponent} from "./modules/security/components/login/login.component";
import {CreateGradeComponent} from "./modules/course/components/create-grade/create-grade.component";
import {CreateAttendanceComponent} from "./modules/course/components/create-attendance/create-attendance.component";
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {ViewCourseComponent} from "./modules/course/components/view-course/view-course.component";
import {ViewAttendanceComponent} from "./modules/course/components/view-attendance/view-attendance.component";
import {CreateQuizComponent} from "./modules/course/components/quiz/create-quiz/create-quiz.component";
import {ViewGradeComponent} from "./modules/course/components/grade/view-grade/view-grade.component";
import {ViewStudentGradeComponent} from "./modules/course/components/grade/view-student-grade/view-student-grade.component";

// import {ViewStudentAttendanceComponent} from "./modules/course/components/view-student-attendance/view-student-attendance.component";
//import {AddQuizQuestionsComponent} from "./modules/course/components/quiz/add-quiz-questions/add-quiz-questions.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: FullLayoutComponent, children:[
      {path: 'home', component: HomeComponent},
      {path: 'create-grade', component: CreateGradeComponent},
      {path:'course/new', component: CreateCourse},
      {path:'course/view', component: ViewCourseComponent},

      {path: 'attend', component: CreateAttendanceComponent} ,
      {path:'course/quiz/new',component:CreateQuizComponent} ,
     // {path:'course/quiz/add_questions',component:AddQuizQuestionsComponent} ,
      {path: 'attend', component: CreateAttendanceComponent},
      {path:'course/new', component: CreateCourse},
      {path:'view-grade', component: ViewGradeComponent},
      {path:'std-grade',component:ViewStudentGradeComponent},
      {path: 'view-attend', component: ViewAttendanceComponent},
      // {path: 'view-student-attend', component: ViewStudentAttendanceComponent},

    ]},
  {path: '', component: SimpleLayoutComponent, children:[
      {path: 'login', component: LoginComponent},

      //TODO: Yara - should be in Full Layout
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
