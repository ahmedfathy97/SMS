import {Component, Input, OnInit} from '@angular/core';
import {AngularFullRoutes} from "../../../../../infrastructure/data/full-routes.enum";
import {AuthViews} from "../../../../../infrastructure/directives/authorization/data/auth-views.enum";

@Component({
  selector: 'app-setting-side-bar',
  templateUrl: './setting-side-bar.component.html',
  styleUrls: ['./setting-side-bar.component.css']
})
export class SettingSideBarComponent implements OnInit {

  AUTH_VIEWS: typeof AuthViews = AuthViews;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;

  constructor() { }

  ngOnInit() {
  }

}
