import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {ActivatedRoute} from "@angular/router";
import {LectureDto} from "../../../../../shared/data/lecture-dto.data";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AuthViews} from "../../../../../../../infrastructure/directives/authorization/data/auth-views.enum";


@Component({
  selector: 'app-course-lecture',
  templateUrl: './create-lecture.component.html',
  styleUrls: ['./create-lecture.component.css'],
  providers: [FormBuilder ,CourseService]
})
export class CreateLecture implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  corID :number ;
  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService,private route: ActivatedRoute ,
              private corDataService: CourseDataService) {
    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
      }
    );
    this.corDataService.requestCorID.next(true);

  }

  ngOnInit() {
  }

  formData: FormGroup = this.formBuilder.group({
    title: [null, [Validators.maxLength(25),Validators.required]],
    lectureDate: [null, [Validators.required]],
    videoUrl: [null],
    description: [null, [Validators.maxLength(200)]]
  });
  get form() { return this.formData.controls; }

  onSubmitNewLecture() {
    let lectureDto: LectureDto = new LectureDto();
    lectureDto.title = this.formData.get('title').value;
    lectureDto.date = this.formData.get('lectureDate').value;
    lectureDto.videoUrl = this.formData.get('videoUrl').value;
    lectureDto.description = this.formData.get('description').value;
    this.courseService.createNewLecture(this.corID ,lectureDto).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }
  clear()
  {
    this.formData.reset();
  }
}
