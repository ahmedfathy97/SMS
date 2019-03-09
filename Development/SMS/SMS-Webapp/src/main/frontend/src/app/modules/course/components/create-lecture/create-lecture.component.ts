import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LectureDto} from "../../shared/data/lecture-dto.data";
import {LectureService} from "../../shared/services/lecture.service";

@Component({
  selector: 'app-course-lecture',
  templateUrl: './create-lecture.component.html',
  styleUrls: ['./create-lecture.component.css'],
  providers: [LectureService]
})
export class CreateLecture implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private lecService: LectureService,) { }

  ngOnInit() {
  }

  formData: FormGroup = this.formBuilder.group({
    title: [null, [Validators.maxLength(25)]],
    date: [null, [Validators.required]],
    videoUrl: [null],
    description: [null, [Validators.maxLength(200)]]
  });

  onSubmitNewLecture() {
    let data: LectureDto = new LectureDto();

    data.title = this.formData.get('title').value;
    data.date = this.formData.get('date').value;
    data.videoUrl = this.formData.get('videoUrl').value;
    data.description = this.formData.get('description').value;

    this.lecService.createNewLecture(data).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }
}
