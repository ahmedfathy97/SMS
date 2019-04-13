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
import { CreateGradeComponent } from './modules/course/components/grade/create-grade/create-grade.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import { CreateAttendanceComponent } from './modules/course/components/attendance/create-attendance/create-attendance.component';

// import { QuillModule } from 'ngx-quill'
import {HttpClientModule} from "@angular/common/http";
//import { CreateTutorialComponent } from './modules/components/tutorialcreate-tutorial/create-tutorial.component';
import { ViewGradeComponent } from './modules/course/components/grade/view-grade/view-grade.component';
import { ViewAttendanceComponent } from './modules/course/components/attendance/view-attendance/view-attendance.component';
import { CreateQuizComponent } from './modules/course/components/quiz/create-quiz/create-quiz.component';
import { UploadComponent } from './infrastructure/components/manage-attachment/components/upload/upload.component';
import { DownloadComponent } from './infrastructure/components/manage-attachment/components/download/download.component';
import {AddQuizQuestionsComponent} from "./modules/course/components/quiz/add-quiz-questions/add-quiz-questions.component";
import { ViewStudentGradeComponent } from './modules/course/components/grade/view-student-grade/view-student-grade.component';
import { ViewStudentAttendanceComponent } from './modules/course/components/attendance/view-student-attendance/view-student-attendance.component';
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {ViewCourseComponent} from "./modules/course/components/view-course/view-course.component";
import { CreateLecture } from './modules/course/components/create-lecture/create-lecture.component';
import {UserProfileComponent} from "./modules/user/components/user-profile/user-profile.component";
import { AnswerQuestionsComponent } from './modules/course/components/quiz/answer-questions/answer-questions.component';
import { CourseQuizesComponent } from './modules/course/components/course-details/course-quizes/course-quizes.component';
import { CourseDetailsComponent } from './modules/course/components/course-details/course-details.component';
import { CourseLecturesComponent } from './modules/course/components/course-details/course-lectures/course-lectures.component';
import { LectureDetailsComponent } from './modules/course/components/lecture-details/lecture-details.component';
//import {TutorialsComponent} from "./modules/course/components/tutorials/tutorials.component";


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
    UserProfileComponent,
    ViewGradeComponent,
    UploadComponent,
    DownloadComponent,
    ViewStudentGradeComponent ,
    AddQuizQuestionsComponent,
    ViewStudentAttendanceComponent,
    CreateLecture,
    AnswerQuestionsComponent,
    CourseQuizesComponent,
    CourseDetailsComponent,
    CourseLecturesComponent,
    LectureDetailsComponent,
  //  TutorialsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule,CommonModule,FormsModule,HttpClientModule
     // ,QuillModule

  ],
  providers: [],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
