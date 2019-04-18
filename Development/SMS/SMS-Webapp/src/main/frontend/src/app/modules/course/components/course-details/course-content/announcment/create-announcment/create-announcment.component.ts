import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AnnouncementService} from "../../../../../shared/services/announcement.service";
import {ActivatedRoute} from "@angular/router";
import {Announcement} from "../../../../../shared/data/announcement";
@Component({
  selector: 'app-create-announcment',
  templateUrl: './create-announcment.component.html',
  styleUrls: ['./create-announcment.component.css'],
  providers: [FormBuilder,AnnouncementService],

})
export class CreateAnnouncmentComponent implements OnInit {

  courseID: string;
  corID :number ;
  formData = this.formBuilder.group({
    title: ['', Validators.required],
    description :['', Validators.required],
  });

  announcement: Announcement = new Announcement();

  constructor(private formBuilder: FormBuilder, private announcementService : AnnouncementService ,
              private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params =>  {
      this.courseID = params.get("courseID");
    })
  }

  ngOnInit() {
  }

  onSubmitNewAnnouncement() {
    let announcement: Announcement = new Announcement();
    announcement.title = this.formData.get('title').value;
    announcement.content= this.formData.get('description').value;
    var courseID = +this.courseID;
    this.corID = courseID ;
    this.announcementService.createNewAnnouncement(this.corID ,announcement).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }

}
