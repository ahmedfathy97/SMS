import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../../../../../shared/services/user.service";
import {UserData} from "../../../../../../../shared/data/user-data";
import {AngularFullRoutes, replaceUserID} from "../../../../../../../../../infrastructure/data/full-routes.enum";
import {UserDataService} from "../../../../../../../shared/services/user-data.service";

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


   userID:number;


   private userData: UserData=new  UserData();

  constructor(private userService:UserService,
              private userDataService:UserDataService,
              private route:ActivatedRoute,
             /* private editService:EditData */) {
    // this.route.paramMap.subscribe(params => {
    //   this.userID = +params.get("userID");
    //
    //
    //   // var userID =+this.userID ;
    //   this.userService.findByID(this.userID).subscribe(
    //     res=> { this.userData=res ;});
    //
    // })
    this.userDataService.userID.subscribe(
      data =>{
        this.userID = data;
        console.log(data);
        this.userService.findByID(this.userID).subscribe(
          res=> { this.userData=res ;});
        // this.getCourseAnnouncments();
      }
    );
    this.userDataService.requestUserID.next(true);
  }

  ngOnInit(){

  }


  // selectedFile: ImageSnippet;
  // processFile(imageInput: any) {
  //   const file: File = imageInput.files[0];
  //   const reader = new FileReader();
  //   reader.addEventListener('load', (event: any) => {
  //     this.selectedFile = new ImageSnippet(event.target.result, file);
  //
  //
  //     this.userService.uploadImage(this.selectedFile.file).subscribe(
  //       (res) => {
  //
  //       },
  //       (err) => {
  //
  //       })
  //
  //   });
  //   reader.readAsDataURL(file);
  //
  // }



}
