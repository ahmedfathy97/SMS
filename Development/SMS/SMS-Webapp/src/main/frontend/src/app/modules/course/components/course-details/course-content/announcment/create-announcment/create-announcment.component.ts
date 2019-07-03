import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AnnouncementService} from "../../../../../shared/services/announcement.service";
import {ActivatedRoute} from "@angular/router";
import {Announcement} from "../../../../../shared/data/announcment";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {CourseService} from "../../../../../shared/services/course.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {AlertInput} from "../../../../../../../infrastructure/components/alerts/alert-input";
import {SuccessAlert} from "../../../../../../../infrastructure/components/alerts/success-alert.data";
import {FailureAlert} from "../../../../../../../infrastructure/components/alerts/failure-alert.data";
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
  get form() { return this.formData.controls; }

  alert: AlertInput = new AlertInput();
  announcement: Announcement = new Announcement();
  constructor(private formBuilder: FormBuilder, private courseService : CourseService ,
              private corDataService: CourseDataService,
              private route: ActivatedRoute) {

    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        console.log(data);
      }
    );
    this.corDataService.requestCorID.next(true);
  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
  }

  onSubmitNewAnnouncement() {
    this.form.title.markAsDirty();
    let announcement: Announcement = new Announcement();
    announcement.title = this.formData.get('title').value;
    announcement.content= this.formData.get('description').value;
    this.courseService.createNewAnnouncement(this.corID ,announcement).subscribe(
      res => {
        console.log("Success");
        this.alert = new SuccessAlert();
    }, err => {
        this.alert = new FailureAlert(err);
        console.log(err);
    });
  }
  clear()
  {
    this.formData.reset();
  }

}
