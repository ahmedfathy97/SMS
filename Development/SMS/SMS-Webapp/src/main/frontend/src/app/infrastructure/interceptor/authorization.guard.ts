import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {LocalStorageService} from "../services/local-storage.service";

@Injectable()
export class AuthorizationGuard implements CanActivate {

  constructor(private localStorageService: LocalStorageService, private router: Router){

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.localStorageService.getCurrentUser().viewIDs.includes(route.data.viewID))
      return true;
    else
      this.router.navigate(['/login']);

  }


}
