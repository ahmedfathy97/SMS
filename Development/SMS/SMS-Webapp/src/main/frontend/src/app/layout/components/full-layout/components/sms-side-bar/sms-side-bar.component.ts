import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-sms-side-bar',
  templateUrl: './sms-side-bar.component.html',
  styleUrls: ['./sms-side-bar.component.css']
})
export class SmsSideBarComponent implements OnInit {
  courseID: string;
  corID :number ;
  constructor(private route: ActivatedRoute ) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
      var courseID  = +this.courseID ;
      this.corID =courseID ;
      console.log(this.corID);
    })
  }

  ngOnInit() {


  }

}
