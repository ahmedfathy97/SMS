import {Component, OnInit, Output} from '@angular/core';
import {AttachmentService} from "../../../../../../../infrastructure/components/manage-attachment/shared/attachment.service";
import {FileVTO} from "../../../../../../../infrastructure/components/manage-attachment/shared/data/FileVTO";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {ActivatedRoute} from "@angular/router";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {LectureService} from "../../../../../shared/services/lecture.service";
import {LectureDto} from "../../../../../shared/data/lecture-dto.data";
import {LectureVto} from "../../../../../shared/data/lecture-vto";
import {AuthActions} from "../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {CourseService} from "../../../../../shared/services/course.service";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";

@Component({
  selector: 'app-lecture-details',
  templateUrl: './lecture-details.component.html',
  styleUrls: ['./lecture-details.component.css'],
  providers: [AttachmentService, LectureService, CourseService]
})
export class LectureDetailsComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  AUTH_VIEWS: typeof AuthViews = AuthViews;

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  replaceLecID = replaceLecID;
  corID :number ;

  lectureData: LectureDto;

  fileSrcID:number;
  lectureID:number;

  files:FileVTO[] = [];

  constructor(private fileService: AttachmentService,
              private route: ActivatedRoute,
              private corDataService: CourseDataService,
              private courseService: CourseService,
              private lecService: LectureService) {

    this.route.paramMap.subscribe(params => {
      this.lectureID = +params.get("lectureID");
      // this.corID = +params.get("corID");

    });

    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
      }
    );
    this.corDataService.requestCorID.next(true);
    this.getLectureData(this.lectureID);
  }

  getLectureData(lectureID: number){
    this.lecService.getLectureData(lectureID).subscribe(res => {
      this.lectureData = res;
    }, err => {
      console.log(err);
    });
  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
  }
  
  player;
  private id: string = 'ZWJH7JQCjLM';
  
  
  savePlayer (player) {
    this.player = player;
    console.log('player instance', player)
  }
  onStateChange(event){
    console.log('player state', event.data);
  }


}
