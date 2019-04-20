import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {ActivatedRoute} from "@angular/router";
import {LectureDto} from "../../../../../shared/data/lecture-dto.data";


@Component({
  selector: 'app-course-lecture',
  templateUrl: './create-lecture.component.html',
  styleUrls: ['./create-lecture.component.css'],
  providers: [FormBuilder ,CourseService]
})
export class CreateLecture implements OnInit {
  courseID :string ;
  corID :number ;
  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService,private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.courseID = params.get("courseID");
    })
  }

  ngOnInit() {
  }

  formData: FormGroup = this.formBuilder.group({
    title: [null, [Validators.maxLength(25)]],
    date: [null, [Validators.required]],
    videoUrl: [null],
    description: [null, [Validators.maxLength(200)]]
  });

  onSubmitNewLecture() {
    let lectureDto: LectureDto = new LectureDto();
    lectureDto.title = this.formData.get('title').value;
    lectureDto.date = this.formData.get('lectureDate').value;
    lectureDto.videoUrl = this.formData.get('videoUrl').value;
    lectureDto.description = this.formData.get('description').value;
    var courseID = +this.courseID;
    this.corID = courseID ;
    this.courseService.createNewLecture(this.corID ,lectureDto).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }
}
