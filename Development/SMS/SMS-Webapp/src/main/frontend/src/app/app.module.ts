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
import { CreateAttendanceComponent } from './modules/course/components/create-attendance/create-attendance.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";

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
    CreateAttendanceComponent
  ],
  imports: [
    BrowserModule,HttpClientModule ,
    AppRoutingModule,FormsModule,ReactiveFormsModule,CommonModule
  ],
  providers: [],
  bootstrap: [LayoutComponent]
})
export class AppModule { }
