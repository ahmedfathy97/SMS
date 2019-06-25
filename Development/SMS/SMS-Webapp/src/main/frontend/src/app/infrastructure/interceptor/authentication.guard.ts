import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {LocalStorageService} from "../services/local-storage.service";
import {AngularFullRoutes} from "../data/full-routes.enum";

@Injectable()
export class AuthenticationGuard implements CanActivate {
  FULL_ROUTES: typeof AngularFullRoutes = AngularFullRoutes;

  constructor(private localStorageService: LocalStorageService, private router: Router){

  }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.localStorageService.getCurrentUser() != null &&
        this.localStorageService.getCurrentUser().token != null)
        return true;
    else
      this.router.navigate([this.FULL_ROUTES.LOGIN]);
  }
}
