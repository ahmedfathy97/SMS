import {Component, Input, OnInit} from '@angular/core';
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../infrastructure/data/full-routes.enum";
import {AuthViews} from "../../../../../infrastructure/directives/authorization/data/auth-views.enum";

@Component({
  selector: 'app-course-side-bar',
  templateUrl: './course-side-bar.component.html',
  styleUrls: ['./course-side-bar.component.css']
})
export class CourseSideBarComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  AUTH_VIEWS: typeof AuthViews = AuthViews;
  replaceCorID = replaceCorID;

  @Input() corID: number;
  @Input() lecID: number;
  constructor()
  {

  }

  ngOnInit() {


  }

}
