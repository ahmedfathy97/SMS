import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../../../../../shared/services/user.service";
//import {UserData} from "../../../../../../../shared/data/user-data";
import {AngularFullRoutes, replaceUserID} from "../../../../../../../../../infrastructure/data/full-routes.enum";
import {UserDataService} from "../../../../../../../shared/services/user-data.service";
import {UserVtoData} from "../../../../../../../shared/data/user-vto.data";
import {LocalStorageService} from "../../../../../../../../../infrastructure/services/local-storage.service";
import {AuthUserVTO} from "../../../../../../../../security/shared/data/auth-user-vto.data";
import {ConfigParam} from "../../../../../../../../../infrastructure/common/config-param";

// class ImageSnippet {
//
//   constructor(public src: string, public file: File) {}
// }

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers:[UserService]
})
export class UserProfileComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceUserID =replaceUserID;

   userID: number;
   private userVto: UserVtoData=new  UserVtoData();
   currentUser: AuthUserVTO = new AuthUserVTO();
  
  BASE_URL: string = ConfigParam.APP_BASE_URL;
  constructor(private userService:UserService,
              private localStorageService: LocalStorageService,
              private userDataService:UserDataService,
              private route:ActivatedRoute,
             /* private editService:EditData */) {
    this.currentUser = this.localStorageService.getCurrentUser();
    
    this.userDataService.userID.subscribe(
      data =>{
        this.userID = data != null ? data : this.currentUser.userID;
        this.userService.findByID(this.userID).subscribe(res=> { this.userVto= res ;});
      }
    );
    this.userDataService.requestUserID.next(true);
  }

  ngOnInit(){

  }
}
