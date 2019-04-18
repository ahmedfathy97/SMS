import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../../../../shared/services/course.service";

@Component({
  selector: 'app-view-announcment',
  templateUrl: './view-announcment.component.html',
  styleUrls: ['./view-announcment.component.scss'] ,
  providers: [CourseService]
})
export class ViewAnnouncmentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
