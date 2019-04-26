import {Component, Input, OnInit} from '@angular/core';
import {AngularFullRoutes} from "../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-setting-side-bar',
  templateUrl: './setting-side-bar.component.html',
  styleUrls: ['./setting-side-bar.component.css']
})
export class SettingSideBarComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;

  constructor() { }

  ngOnInit() {
  }

}
