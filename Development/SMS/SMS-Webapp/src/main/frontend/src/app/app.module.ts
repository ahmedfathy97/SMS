import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FullLayoutComponent } from './layout/components/full-layout/full-layout.component';
import { SimpleLayoutComponent } from './layout/components/simple-layout/simple-layout.component';
import { SmsHeaderComponent } from './layout/components/full-layout/components/sms-header/sms-header.component';
import { CourseSideBarComponent } from './modules/course/components/course-details/course-side-bar/course-side-bar.component';
import { SmsFooterComponent } from './layout/components/full-layout/components/sms-footer/sms-footer.component';
import { HomeComponent } from './modules/home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './modules/security/components/login/login.component';
import { CreateGradeComponent } from './modules/course/components/course-details/course-content/grade/create-grade/create-grade.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import { CreateAttendanceComponent } from './modules/course/components/course-details/course-content/attendance/create-attendance/create-attendance.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { ViewGradeComponent } from './modules/course/components/course-details/course-content/grade/view-grade/view-grade.component';
import { ViewAttendanceComponent } from './modules/course/components/course-details/course-content/attendance/view-attendance/view-attendance.component';
import { CreateQuizComponent } from './modules/course/components/course-details/course-content/quiz/create-quiz/create-quiz.component';
import { UploadComponent } from './infrastructure/components/manage-attachment/components/upload/upload.component';
import { DownloadComponent } from './infrastructure/components/manage-attachment/components/download/download.component';
import {AddQuizQuestionsComponent} from "./modules/course/components/course-details/course-content/quiz/add-quiz-questions/add-quiz-questions.component";
import { ViewStudentGradeComponent } from './modules/course/components/course-details/course-content/grade/view-student-grade/view-student-grade.component';
import { ViewStudentAttendanceComponent } from './modules/course/components/course-details/course-content/attendance/view-student-attendance/view-student-attendance.component';
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {CourseInfoComponent} from "./modules/course/components/course-details/course-content/course-info/course-info.component";
import { CreateLecture } from './modules/course/components/course-details/course-content/lecture/create-lecture/create-lecture.component';
import {UserProfileComponent} from "./modules/user/components/user-profile/user-profile.component";
import { AnswerQuestionsComponent } from './modules/course/components/course-details/course-content/quiz/answer-questions/answer-questions.component';

import { UserEditComponent } from './modules/user/components/user-edit/user-edit.component';
import {RegisterComponent} from "./modules/security/components/register/register.component";
import {AuthorizeActionDirective} from "./infrastructure/directives/authorization/authorize-action.directive";
import {AuthorizeViewDirective} from "./infrastructure/directives/authorization/authorize-view.directive";
import {UnAuthorizedComponent} from "./modules/security/components/un-authorized/un-authorized.component";
import {AuthorizationGuard} from "./infrastructure/interceptor/authorization.guard";
import {AuthInterceptor} from "./infrastructure/interceptor/auth-interceptor";
import {AuthenticationGuard} from "./infrastructure/interceptor/authentication.guard";
import {LocalStorageService} from "./infrastructure/services/local-storage.service";
import { CourseDetailsComponent } from './modules/course/components/course-details/course-details.component';
import {CourseQuizesComponent} from "./modules/course/components/course-details/course-content/quiz/course-quizes/course-quizes.component";
import {CourseLecturesComponent} from "./modules/course/components/course-details/course-content/lecture/course-lectures/course-lectures.component";
import { CourseListComponent } from './modules/course/components/course-list/course-list.component';
import { CreateAnnouncmentComponent } from './modules/course/components/course-details/course-content/announcment/create-announcment/create-announcment.component';
import { ViewAnnouncmentComponent } from './modules/course/components/course-details/course-content/announcment/view-announcment/view-announcment.component';
import {CourseDataService} from "./modules/course/shared/services/course-data.service";

@NgModule({
  declarations: [
    FullLayoutComponent, SimpleLayoutComponent, SmsHeaderComponent, CourseSideBarComponent, SmsFooterComponent,
    HomeComponent, LayoutComponent, CreateGradeComponent, CreateAttendanceComponent, CreateCourse,
    CourseInfoComponent, ViewAttendanceComponent, CreateQuizComponent, ViewGradeComponent,
    UserProfileComponent, UploadComponent, DownloadComponent, ViewStudentGradeComponent ,
    AddQuizQuestionsComponent, ViewStudentAttendanceComponent, CreateLecture, AnswerQuestionsComponent,
    CourseQuizesComponent, CourseLecturesComponent,CourseDetailsComponent ,
    UserEditComponent, RegisterComponent, LoginComponent, AuthorizeActionDirective, AuthorizeViewDirective,
    UnAuthorizedComponent,
    CourseListComponent,
    CreateAnnouncmentComponent,
    ViewAnnouncmentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule,CommonModule,FormsModule,HttpClientModule
  ],
  providers: [
    LocalStorageService, AuthorizationGuard, AuthenticationGuard,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
