import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {LocalStorageService} from "../services/local-storage.service";
import {AngularFullRoutes} from "../data/full-routes.enum";

@Injectable()
export class LoginGuard implements CanActivate {
  FULL_ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  
  constructor(private localStorageService: LocalStorageService, private router: Router){
  
  }
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(state.url == this.FULL_ROUTES.LOGIN && this.localStorageService.getCurrentUser() != null &&
      this.localStorageService.getCurrentUser().token != null)
      this.router.navigate([this.FULL_ROUTES.HOME]);
    else
      return true;
    
  }
  
  
}
