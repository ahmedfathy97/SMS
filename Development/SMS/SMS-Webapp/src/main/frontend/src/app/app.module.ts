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
//import {UserProfileComponent} from "./modules/user/components/user-profile/user-profile.component";
import { AnswerQuestionsComponent } from './modules/course/components/course-details/course-content/quiz/quiz-details/answer-questions/answer-questions.component';

//import { UserEditComponent } from './modules/user/components/user-edit/user-edit.component';
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
import { LectureDetailsComponent } from './modules/course/components/course-details/course-content/lecture/lecture-details/lecture-details.component';
import {SmsSideBarComponent} from "./layout/components/full-layout/components/sms-side-bar/sms-side-bar.component";
import {SettingSideBarComponent} from "./modules/settings/components/setting-details/setting-side-bar/setting-side-bar.component";
import { SettingDetailsComponent } from './modules/settings/components/setting-details/setting-details.component';
// import {UserListComponent} from "./modules/settings/components/setting-content/user-list/user-list.component";
// import { UserDetailComponent } from './modules/settings/components/setting-content/user/user-detail/user-detail.component';
// import { UserSideBarComponent } from './modules/settings/components/setting-content/user/user-detail/user-side-bar/user-side-bar.component';
//import { UserContentComponent } from './modules/settings/components/setting-content/user/user-detail/user-content/user-content.component';
import { UserSettingsComponent } from './modules/settings/components/setting-content/user/component/user-detail/user-content/user-settings/user-settings.component';
import {UserProfileComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-content/user-profile/user-profile.component";
import {UserEditComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-content/user-edit/user-edit.component";
import {UserListComponent} from "./modules/settings/components/setting-content/user/component/user-list/user-list.component";
import {UserDetailComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-detail.component";
import {UserSideBarComponent} from "./modules/settings/components/setting-content/user/component/user-detail/user-side-bar/user-side-bar.component";
import { MyCourseComponent } from './modules/course/components/my-course/my-course.component';
import {QuizMainDetailComponent} from "./modules/course/components/course-details/course-content/quiz/quiz-details/quiz-main-detail/quiz-main-detail.component";
import { QuizDetailsComponent } from './modules/course/components/course-details/course-content/quiz/quiz-details/quiz-details.component';
//import { SettindSidebarComponent } from './modules/settings/components/setting-side-bar/settind-sidebar.component';

// import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
//import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


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
    CourseListComponent, SmsSideBarComponent,
    CreateAnnouncmentComponent,
    ViewAnnouncmentComponent,
    LectureDetailsComponent,
    UserListComponent,
    SettingSideBarComponent,
    SettingDetailsComponent,
    UserDetailComponent,
    UserSideBarComponent,
    UserSettingsComponent,
    MyCourseComponent,
    QuizMainDetailComponent,
    QuizDetailsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,ReactiveFormsModule,CommonModule,FormsModule,HttpClientModule,
  //  NgbModule
    // NgbModule
  ],
  providers: [
    LocalStorageService, AuthorizationGuard, AuthenticationGuard,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  bootstrap: [LayoutComponent]
})
export class AppModule {
  private static UserContentComponent: any;
}
