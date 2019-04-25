import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID} from "../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-course-side-bar',
  templateUrl: './course-side-bar.component.html',
  styleUrls: ['./course-side-bar.component.css']
})
export class CourseSideBarComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  @Input() corID: number;
  constructor()
  {

  }

  ngOnInit() {


  }

}
