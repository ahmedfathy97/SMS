import { Component, OnInit } from '@angular/core';
import {UserService} from "../../shared/user.service";
import {UserVto} from "../../shared/data/user-vto";
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers:[UserService]
})
export class UserProfileComponent implements OnInit {
   private userData: UserVto=new  UserVto();
  constructor(private userService:UserService) { }

  ngOnInit() {
    this.userService.findByID(1).subscribe(
      res=> { this.userData=res ;});
  }

}
