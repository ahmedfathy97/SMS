import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "../../infrastructure/services/local-storage.service";
import {AngularFullRoutes, replaceUserID} from "../../infrastructure/data/full-routes.enum";
import {AuthUserVTO} from "../security/shared/data/auth-user-vto.data";
import {AuthViews} from "../../infrastructure/directives/authorization/data/auth-views.enum";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  AUTH_VIEWS: typeof AuthViews = AuthViews;
  
  isUserAuthenticated: boolean = false;
  currentUser: AuthUserVTO = new AuthUserVTO();
  
  replaceUserID = replaceUserID;
  constructor(private localStorageService: LocalStorageService,
              private router: Router) {
    this.isUserAuthenticated = (this.localStorageService.getCurrentUser() != null
      && this.localStorageService.getCurrentUser().token != null);
    this.currentUser = this.localStorageService.getCurrentUser();
  }

  ngOnInit() {
  }
  
  logOut(){
    this.localStorageService.clearAuthUser();
    this.router.navigate([this.ROUTES.LOGIN]);
  }

}
