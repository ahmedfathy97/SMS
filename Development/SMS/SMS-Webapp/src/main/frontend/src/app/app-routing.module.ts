import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FullLayoutComponent} from "./layout/components/full-layout/full-layout.component";
import {HomeComponent} from "./modules/home/home.component";
import {SimpleLayoutComponent} from "./layout/components/simple-layout/simple-layout.component";
import {LoginComponent} from "./modules/security/components/login/login.component";
import {CreateGradeComponent} from "./modules/course/components/create-grade/create-grade.component";
import {CreateAttendanceComponent} from "./modules/course/components/create-attendance/create-attendance.component";
import {CourseDetailsComponent} from "./modules/course/components/create-course/course-details/course-details.component";

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '', component: FullLayoutComponent, children:[
      {path: 'home', component: HomeComponent},
      {path: 'create-grade', component: CreateGradeComponent},
      {path:'course/new', component: CourseDetailsComponent}
    ]},
  {path: '', component: SimpleLayoutComponent, children:[
      {path: 'login', component: LoginComponent},
      //TODO: Yara - should be in Full Layout
      {path: 'attend', component: CreateAttendanceComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
