import { Component, OnInit } from '@angular/core';
import {AuthUserVTO} from "../../../../../modules/security/shared/data/auth-user-vto.data";
import {LocalStorageService} from "../../../../../infrastructure/services/local-storage.service";
import {Router} from "@angular/router";
import {AngularFullRoutes} from "../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-sms-header',
  templateUrl: './sms-header.component.html',
  styleUrls: ['./sms-header.component.css']
})
export class SmsHeaderComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  currentUser: AuthUserVTO = new AuthUserVTO();

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
