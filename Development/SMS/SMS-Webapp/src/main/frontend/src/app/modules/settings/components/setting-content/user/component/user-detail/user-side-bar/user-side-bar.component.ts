import {Component, Input, OnInit} from '@angular/core';
import {AngularFullRoutes, replaceUserID} from "../../../../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-user-side-bar',
  templateUrl: './user-side-bar.component.html',
  styleUrls: ['./user-side-bar.component.css']
})
export class UserSideBarComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceUserID=replaceUserID;
  @Input() userID:number;
  constructor() { }

  ngOnInit() {
  }

}
