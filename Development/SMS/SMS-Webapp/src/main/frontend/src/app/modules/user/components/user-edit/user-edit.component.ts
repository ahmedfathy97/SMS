import { Component, OnInit } from '@angular/core';
import {UserData} from "../../shared/data/user-data";
import {UserService} from "../../shared/user.service";
import {ActivatedRoute} from "@angular/router";


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

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.userID = params.get("userID");

    })
  }

    ngOnInit()
    {

    }

}
