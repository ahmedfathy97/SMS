import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-course-side-bar',
  templateUrl: './course-side-bar.component.html',
  styleUrls: ['./course-side-bar.component.css']
})
export class CourseSideBarComponent implements OnInit {

  @Input() corID: number;
  constructor()
  {

  }

  ngOnInit() {


  }

}
