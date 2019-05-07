import { Component, OnInit } from '@angular/core';
import {AttachmentService} from "../../../../../../../infrastructure/components/manage-attachment/shared/attachment.service";
import {FileVTO} from "../../../../../../../infrastructure/components/manage-attachment/shared/data/FileVTO";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {LectureService} from "../../../../../shared/services/lecture.service";
import {LectureDto} from "../../../../../shared/data/lecture-dto.data";
import {LectureVto} from "../../../../../shared/data/lecture-vto";

@Component({
  selector: 'app-lecture-details',
  templateUrl: './lecture-details.component.html',
  styleUrls: ['./lecture-details.component.css'],
  providers: [AttachmentService, LectureService]
})
export class LectureDetailsComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  // replaceLecID = replaceLecID;
  replaceCorID = replaceCorID;
  corID :number ;

  lectureData: LectureDto;

  fileSrcID:number;
  lectureID:number;


  files:FileVTO[] = [];

  constructor(private fileService: AttachmentService,
              private route: ActivatedRoute,
              private corDataService: CourseDataService,
              private lecService: LectureService) {

    this.route.paramMap.subscribe(params => {
      this.lectureID = +params.get("lectureID");
    });
    // console.log("LectureDetails: "+ this.lectureID)
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
      }
    );
    this.corDataService.requestCorID.next(true);
    this.getLectureData(this.lectureID);
  }

  getLectureData(lectureID: number){
    this.lecService.getLectureData(lectureID).subscribe(res => {
      this.lectureData = res;
      console.log(this.lectureData.title)
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {}



}
