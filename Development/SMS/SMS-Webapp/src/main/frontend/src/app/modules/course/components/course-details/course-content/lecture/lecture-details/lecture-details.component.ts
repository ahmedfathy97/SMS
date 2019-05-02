import { Component, OnInit } from '@angular/core';
import {AttachmentService} from "../../../../../../../infrastructure/components/manage-attachment/shared/attachment.service";
import {FileVTO} from "../../../../../../../infrastructure/components/manage-attachment/shared/data/FileVTO";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-lecture-details',
  templateUrl: './lecture-details.component.html',
  styleUrls: ['./lecture-details.component.css'],
  providers: [AttachmentService]
})
export class LectureDetailsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceLecID = replaceLecID;
  replaceCorID = replaceCorID;

  lectureTitle:string;
  // change to dynamic
  fileSrcID:number;

  lectureID:number;


  files:FileVTO[] = [];

  constructor(private fileService: AttachmentService,
              private route: ActivatedRoute,) {

    this.route.paramMap.subscribe(params => {
      this.lectureID = +params.get("lectureID");
    });
    console.log("LectureDetails: "+ this.lectureID)
  }



  ngOnInit() {}



}
