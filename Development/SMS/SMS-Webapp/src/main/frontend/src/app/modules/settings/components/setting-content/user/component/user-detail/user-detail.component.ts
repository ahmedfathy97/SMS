import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UserDataService} from "../../../../../shared/services/user-data.service";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  providers:[UserDataService]

})
export class UserDetailComponent implements OnInit {
  userID:number;

  constructor(private route: ActivatedRoute,
              private userDataService: UserDataService) {
    this.route.paramMap.subscribe(params => {
      this.userID = +params.get("userID");
    });
    this.userDataService.requestUserID.subscribe(
      data => {
        this.userDataService.userID.next(this.userID);
      }
    )
  }

  ngOnInit() {
  }

}
