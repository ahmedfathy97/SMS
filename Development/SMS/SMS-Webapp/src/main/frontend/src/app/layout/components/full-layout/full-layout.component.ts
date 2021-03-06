import { Component, OnInit } from '@angular/core';
import {AngularFullRoutes} from "../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-full-layout',
  templateUrl: './full-layout.component.html',
  styleUrls: ['./full-layout.component.css']
})
export class FullLayoutComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;

  constructor() { }

  ngOnInit() {
  }

}
