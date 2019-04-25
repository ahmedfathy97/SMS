import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AnnouncementService} from "../../../../../shared/services/announcement.service";
import {ActivatedRoute} from "@angular/router";
import {Announcement} from "../../../../../shared/data/announcment";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {CourseService} from "../../../../../shared/services/course.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
@Component({
  selector: 'app-create-announcment',
  templateUrl: './create-announcment.component.html',
  styleUrls: ['./create-announcment.component.css'],
  providers: [FormBuilder,CourseService],

})
export class CreateAnnouncmentComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  //courseID: string;
  corID :number ;
  formData = this.formBuilder.group({
    title: ['', Validators.required],
    description :['', Validators.required],
  });

  announcement: Announcement = new Announcement();

  constructor(private formBuilder: FormBuilder, private courseService : CourseService ,
              private corDataService: CourseDataService,
              private route: ActivatedRoute) {
    // this.route.paramMap.subscribe(params =>  {
    //   this.courseID = params.get("courseID");
    // })
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
      }
    );
    this.corDataService.requestCorID.next(true);
  }

  ngOnInit() {
  }

  onSubmitNewAnnouncement() {
    let announcement: Announcement = new Announcement();
    announcement.title = this.formData.get('title').value;
    announcement.content= this.formData.get('description').value;
    // var courseID = +this.courseID;
    // this.corID = courseID ;
    this.courseService.createNewAnnouncement(this.corID ,announcement).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }

}
