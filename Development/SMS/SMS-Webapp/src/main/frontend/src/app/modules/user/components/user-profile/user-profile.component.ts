import { Component, OnInit } from '@angular/core';
import {UserService} from "../../shared/user.service";
import {UserData} from "../../shared/data/user-data";
import {ActivatedRoute} from "@angular/router";
//import {EditData} from "../../shared/data/edit-data";


class ImageSnippet {

  constructor(public src: string, public file: File) {}
}

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers:[UserService]
})
export class UserProfileComponent implements OnInit {

   userID:string;


   private userData: UserData=new  UserData();

  constructor(private userService:UserService,
              private route:ActivatedRoute,
             /* private editService:EditData */) {
    this.route.paramMap.subscribe(params => {
      this.userID = params.get("userID");

    })
  }

  ngOnInit(){
    var userID =+this.userID ;
    this.userService.findByID(userID).subscribe(
      res=> { this.userData=res ;});
  }

  onEdit(){


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

  onEdit(){



  }

}
