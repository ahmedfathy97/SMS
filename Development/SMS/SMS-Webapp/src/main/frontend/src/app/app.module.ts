import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FullLayoutComponent } from './layout/components/full-layout/full-layout.component';
import { SimpleLayoutComponent } from './layout/components/simple-layout/simple-layout.component';
import { SmsHeaderComponent } from './layout/components/full-layout/components/sms-header/sms-header.component';
import { SmsSideBarComponent } from './layout/components/full-layout/components/sms-side-bar/sms-side-bar.component';
import { SmsFooterComponent } from './layout/components/full-layout/components/sms-footer/sms-footer.component';
import { HomeComponent } from './modules/home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './modules/security/components/login/login.component';
import { CreateGradeComponent } from './modules/course/components/create-grade/create-grade.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import { CreateAttendanceComponent } from './modules/course/components/attendance/create-attendance/create-attendance.component';

//import { QuillModule } from 'ngx-quill'
import {HttpClientModule} from "@angular/common/http";
// import { CourseDetailsComponent } from './modules/course/components/create-course/course-details/course-details.component';
//import { CreateTutorialComponent } from './modules/tutorial/components/create-tutorial/create-tutorial.component';
import { ViewGradeComponent } from './modules/course/components/grade/view-grade/view-grade.component';
import { ViewAttendanceComponent } from './modules/course/components/attendance/view-attendance/view-attendance.component';
import { CreateQuizComponent } from './modules/course/components/quiz/create-quiz/create-quiz.component';
//import { UploadComponent } from './infrastructure/components/manage-attachment/components/upload/upload.component';
//import { DownloadComponent } from './infrastructure/components/manage-attachment/components/download/download.component';
//import { ViewStudentAttendanceComponent } from './modules/course/components/view-student-attendance/view-student-attendance.component';
import {AddQuizQuestionsComponent} from "./modules/course/components/quiz/add-quiz-questions/add-quiz-questions.component";
import { ViewStudentGradeComponent } from './modules/course/components/grade/view-student-grade/view-student-grade.component';
import { ViewStudentAttendanceComponent } from './modules/course/components/attendance/view-student-attendance/view-student-attendance.component';
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {ViewCourseComponent} from "./modules/course/components/view-course/view-course.component";


@NgModule({
  declarations: [
    FullLayoutComponent,
    SimpleLayoutComponent,
    SmsHeaderComponent,
    SmsSideBarComponent,
    SmsFooterComponent,
    HomeComponent,
    LayoutComponent,
    LoginComponent,
    CreateGradeComponent,
    CreateAttendanceComponent,
    CreateCourse,
    ViewCourseComponent,
    ViewAttendanceComponent,

    CreateQuizComponent,
    ViewGradeComponent,
    //UploadComponent,
  //  DownloadComponent,
    AddQuizQuestionsComponent ,
   //ViewStudentAttendanceComponent,
    ViewStudentGradeComponent ,
    AddQuizQuestionsComponent,
    ViewStudentAttendanceComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule,CommonModule,FormsModule,
    BrowserModule,HttpClientModule ,
    BrowserModule,HttpClientModule ,//QuillModule

  ],
  providers: [],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
