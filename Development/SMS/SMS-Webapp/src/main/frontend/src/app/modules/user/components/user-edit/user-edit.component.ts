import { Component, OnInit } from '@angular/core';
import {UserVto} from "../../shared/data/user-vto";
import {UserService} from "../../shared/user.service";
import {ActivatedRoute} from "@angular/router";
import {EditVto} from "../../shared/data/edit-vto";


class ImageSnippet {

  constructor(public src: string, public file: File) {}
}
@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css'],
  providers:[UserService]
})
export class UserEditComponent implements OnInit {

  userID: string;
  private userData: EditVto=new EditVto() ;

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.userID = params.get("userID");

    })
  }

    ngOnInit()
    {
      this.userService.findByID(5).subscribe(
        res => {
          this.userData = res;
        });
    }

}
