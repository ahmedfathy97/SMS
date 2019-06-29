import {Component, Input, OnInit} from '@angular/core';
import {AuthUserVTO} from "../../../../../modules/security/shared/data/auth-user-vto.data";
import {LocalStorageService} from "../../../../../infrastructure/services/local-storage.service";
import {Router} from "@angular/router";
import {AngularFullRoutes, replaceUserID} from "../../../../../infrastructure/data/full-routes.enum";
import {AuthViews} from "../../../../../infrastructure/directives/authorization/data/auth-views.enum";

@Component({
  selector: 'app-sms-header',
  templateUrl: './sms-header.component.html',
  styleUrls: ['./sms-header.component.css']
})
export class SmsHeaderComponent implements OnInit {
  @Input() showLogo: boolean;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  AUTH_VIEWS: typeof AuthViews = AuthViews;
  currentUser: AuthUserVTO = new AuthUserVTO();
  
  replaceUserID = replaceUserID;
  constructor(private localStorageService: LocalStorageService,
              private router: Router) {
    this.currentUser = this.localStorageService.getCurrentUser();
  }

  ngOnInit() {
  }

  logOut(){
    this.localStorageService.clearAuthUser();
    this.router.navigate([this.ROUTES.LOGIN]);
  }

}
