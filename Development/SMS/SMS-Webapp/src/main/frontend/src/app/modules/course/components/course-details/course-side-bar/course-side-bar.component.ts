import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../infrastructure/data/full-routes.enum";
import {AuthViews} from "../../../../../infrastructure/directives/authorization/data/auth-views.enum";
import {CourseService} from "../../../shared/services/course.service";
import {LocalStorageService} from "../../../../../infrastructure/services/local-storage.service";
import {AuthUserVTO} from "../../../../security/shared/data/auth-user-vto.data";
import {AuthRoles} from "../../../../../infrastructure/directives/authorization/data/auth-roles.enum";

@Component({
  selector: 'app-course-side-bar',
  templateUrl: './course-side-bar.component.html',
  styleUrls: ['./course-side-bar.component.css'],
  providers: [CourseService]
})
export class CourseSideBarComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  AUTH_VIEWS: typeof AuthViews = AuthViews;
  AUTH_ROLES: typeof AuthRoles = AuthRoles;
  replaceCorID = replaceCorID;
  replaceLecID = replaceLecID;

  @Input() corID: number;
  @Input() lecID: number;
  isStudentEnroll: boolean;
  currentUser: AuthUserVTO =new AuthUserVTO();
  constructor(private corService: CourseService,
              private localStorageService: LocalStorageService)
  {
      this.currentUser =this.localStorageService.getCurrentUser();
  }

  ngOnInit() {
    this.corService.getStudentIsEnroll(this.corID).subscribe(res =>{
      this.isStudentEnroll = res;
      console.log(res);
    });


  }

}
