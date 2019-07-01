import {Component, OnInit} from '@angular/core';
import {AuthActions} from "../../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-assignment-details',
  templateUrl: './assignment-details.component.html',
  styleUrls: ['./assignment-details.component.css']
})
export class AssignmentDetailsComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID: number;

  constructor(private corDataService: CourseDataService, private route: ActivatedRoute) {
    this.corDataService.corID.subscribe(
      data => {
        this.corID = data;
      });
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {
  }

}
