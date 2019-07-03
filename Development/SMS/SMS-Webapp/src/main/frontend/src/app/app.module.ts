import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FullLayoutComponent} from './layout/components/full-layout/full-layout.component';
import {SimpleLayoutComponent} from './layout/components/simple-layout/simple-layout.component';
import {SmsHeaderComponent} from './layout/components/full-layout/components/sms-header/sms-header.component';
import {CourseSideBarComponent} from './modules/course/components/course-details/course-side-bar/course-side-bar.component';
import {SmsFooterComponent} from './layout/components/full-layout/components/sms-footer/sms-footer.component';
import {HomeComponent} from './modules/home/home.component';
import {LayoutComponent} from './layout/layout.component';
import {LoginComponent} from './modules/security/components/login/login.component';
import {CreateGradeComponent} from './modules/course/components/course-details/course-content/grade/create-grade/create-grade.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {CreateAttendanceComponent} from './modules/course/components/course-details/course-content/attendance/create-attendance/create-attendance.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {ViewGradeComponent} from './modules/course/components/course-details/course-content/grade/view-grade/view-grade.component';
import {ViewAttendanceComponent} from './modules/course/components/course-details/course-content/attendance/view-attendance/view-attendance.component';
import {CreateQuizComponent} from './modules/course/components/course-details/course-content/quiz/create-quiz/create-quiz.component';
import {UploadComponent} from './infrastructure/components/manage-attachment/components/upload/upload.component';
import {DownloadComponent} from './infrastructure/components/manage-attachment/components/download/download.component';
import {AddQuizQuestionsComponent} from "./modules/course/components/course-details/course-content/quiz/add-quiz-questions/add-quiz-questions.component";
import {CreateCourse} from "./modules/course/components/create-course/create-course.component";
import {CourseInfoComponent} from "./modules/course/components/course-details/course-content/course-info/course-info.component";
import {CreateLecture} from './modules/course/components/course-details/course-content/lecture/create-lecture/create-lecture.component';
import {AnswerQuestionsComponent} from './modules/course/components/course-details/course-content/quiz/quiz-details/answer-questions/answer-questions.component';

import {RegisterComponent} from "./modules/security/components/register/register.component";
import {AuthorizeActionDirective} from "./infrastructure/directives/authorization/authorize-action.directive";
import {AuthorizeViewDirective} from "./infrastructure/directives/authorization/authorize-view.directive";
import {UnAuthorizedComponent} from "./modules/security/components/un-authorized/un-authorized.component";
import {AuthorizationGuard} from "./infrastructure/interceptor/authorization.guard";
import {AuthInterceptor} from "./infrastructure/interceptor/auth-interceptor";
import {AuthenticationGuard} from "./infrastructure/interceptor/authentication.guard";
import {LocalStorageService} from "./infrastructure/services/local-storage.service";
import {CourseDetailsComponent} from './modules/course/components/course-details/course-details.component';
import {CourseQuizesComponent} from "./modules/course/components/course-details/course-content/quiz/course-quizes/course-quizes.component";
import {CourseLecturesComponent} from "./modules/course/components/course-details/course-content/lecture/course-lectures/course-lectures.component";
import {CourseListComponent} from './modules/course/components/course-list/course-list.component';
import {CreateAnnouncmentComponent} from './modules/course/components/course-details/course-content/announcment/create-announcment/create-announcment.component';
import {ViewAnnouncmentComponent} from './modules/course/components/course-details/course-content/announcment/view-announcment/view-announcment.component';
import {LectureDetailsComponent} from './modules/course/components/course-details/course-content/lecture/lecture-details/lecture-details.component';
import {SmsSideBarComponent} from "./layout/components/full-layout/components/sms-side-bar/sms-side-bar.component";
import {SettingSideBarComponent} from "./modules/settings/components/setting-details/setting-side-bar/setting-side-bar.component";
import {SettingDetailsComponent} from './modules/settings/components/setting-details/setting-details.component';
import {UserProfileComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-content/user-profile/user-profile.component";
import {UserEditComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-content/user-edit/user-edit.component";
import {UserListComponent} from "./modules/settings/components/setting-content/user/component/user-list/user-list.component";
import {UserDetailComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-detail.component";
import {UserSideBarComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-side-bar/user-side-bar.component";
import {MyCourseComponent} from './modules/course/components/my-course/my-course.component';
import {QuizMainDetailComponent} from "./modules/course/components/course-details/course-content/quiz/quiz-details/quiz-main-detail/quiz-main-detail.component";
import {AlertComponent} from "./infrastructure/components/alerts/alert.component";
import {QuizResultComponent} from "./modules/course/components/course-details/course-content/quiz/quiz-details/quiz-result/quiz-result.component";
import {QuizDetailsComponent} from "./modules/course/components/course-details/course-content/quiz/quiz-details/quiz-details.component";
import {textSubStrPipe} from "./infrastructure/pipes/text-sub-str.pipe";
import {NgxPaginationModule} from "ngx-pagination";
import { AddExamQuestionsComponent } from './modules/course/components/course-details/course-content/exam/add-exam-questions/add-exam-questions.component';
import { CourseExamsComponent } from './modules/course/components/course-details/course-content/exam/course-exams/course-exams.component';
import { ExamDetailsComponent } from './modules/course/components/course-details/course-content/exam/exam-details/exam-details.component';
import { ExamMainDetailComponent } from './modules/course/components/course-details/course-content/exam/exam-details/exam-main-detail/exam-main-detail.component';
import { ExamResultComponent } from './modules/course/components/course-details/course-content/exam/exam-details/exam-result/exam-result.component';
import {AnswerExamQuestionsComponent} from "./modules/course/components/course-details/course-content/exam/exam-details/answer-exam-questions/answer-exam-questions.component";
import { QuizGradeComponent } from './modules/course/components/course-details/course-content/quiz-grade/quiz-grade.component';
import {LoginGuard} from "./infrastructure/interceptor/login.guard";
import {NgxDaterangepickerMd} from 'ngx-daterangepicker-material';
// import {NgbDatepickerModule} from "@ng-bootstrap/ng-bootstrap";
import {AssignmentDetailsComponent} from './modules/course/components/course-details/course-content/lecture/lecture-details/assignment-details/assignment-details.component';


@NgModule({
  declarations: [
    FullLayoutComponent, SimpleLayoutComponent,
    SmsHeaderComponent, CourseSideBarComponent, SmsFooterComponent,
    HomeComponent, LayoutComponent, CreateGradeComponent, CreateAttendanceComponent, CreateCourse,
    CourseInfoComponent, ViewAttendanceComponent, CreateQuizComponent, ViewGradeComponent,
    UserProfileComponent, UploadComponent, DownloadComponent,
    AddQuizQuestionsComponent, CreateLecture, AnswerQuestionsComponent,
    CourseQuizesComponent, CourseLecturesComponent, CourseDetailsComponent,
    UserEditComponent, RegisterComponent, LoginComponent, AuthorizeActionDirective, AuthorizeViewDirective,
    UnAuthorizedComponent, AlertComponent, CourseListComponent, SmsSideBarComponent, HomeComponent,
    CreateAnnouncmentComponent, ViewAnnouncmentComponent, LectureDetailsComponent, UserListComponent,
    SettingSideBarComponent, SettingDetailsComponent,
    UserDetailComponent,
    UserSideBarComponent,
    MyCourseComponent,
    QuizMainDetailComponent,
    QuizDetailsComponent,
    QuizResultComponent,textSubStrPipe, AddExamQuestionsComponent, CourseExamsComponent, ExamDetailsComponent,
    AnswerExamQuestionsComponent, ExamMainDetailComponent, ExamResultComponent, QuizGradeComponent, AssignmentDetailsComponent,

  ],
  imports: [
    BrowserModule, NgxPaginationModule,
    AppRoutingModule, ReactiveFormsModule, CommonModule, FormsModule, HttpClientModule, NgxDaterangepickerMd.forRoot(), //,
    //NgbModule.forRoot()
  ],
  providers: [
    LocalStorageService, AuthorizationGuard, AuthenticationGuard, LoginGuard,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
  bootstrap: [LayoutComponent]
})
export class AppModule {
}
