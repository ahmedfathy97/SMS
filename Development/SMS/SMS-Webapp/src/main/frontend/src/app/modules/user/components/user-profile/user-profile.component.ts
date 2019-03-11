import { Component, OnInit } from '@angular/core';
import {UserService} from "../../shared/user.service";
import {UserVto} from "../../shared/data/user-vto";
import {ActivatedRoute} from "@angular/router";


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
   private userData: UserVto=new  UserVto();

  constructor(private userService:UserService,
              private route:ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.userID = params.get("userID");

    })
  }

  ngOnInit(){
    this.userService.findByID(1).subscribe(
      res=> { this.userData=res ;});
  }

  selectedFile: ImageSnippet;
  processFile(imageInput: any) {
    const file: File = imageInput.files[0];
    const reader = new FileReader();
    reader.addEventListener('load', (event: any) => {
      this.selectedFile = new ImageSnippet(event.target.result, file);


      this.userService.uploadImage(this.selectedFile.file).subscribe(
        (res) => {

        },
        (err) => {

        })

    });
    reader.readAsDataURL(file);

  }



}
