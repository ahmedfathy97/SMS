import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../shared/services/course.service";
import {CourseVto} from "../../shared/data/course-vto";

@Component({
  selector: 'app-view-course',
  templateUrl: './view-course.component.html',
  styleUrls: ['./view-course.component.css'],
  providers:[CourseService]
})
export class ViewCourseComponent implements OnInit {


  private viewData: CourseVto = new CourseVto();


  constructor(private corService: CourseService) { }

  ngOnInit() {

    this.corService.getCourseByID(1).subscribe(res => {  this.viewData = res ;});
  }

}
