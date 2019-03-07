import { Component, OnInit } from '@angular/core';
import { ToolbarService, LinkService, ImageService, HtmlEditorService, TableService } from '@syncfusion/ej2-angular-richtexteditor';
import {CourseService} from "../../shared/services/course.service";
import {FormBuilder, Validators} from "@angular/forms";
import {CourseVto} from "../../shared/data/course-vto";
@Component({
  selector: 'app-tutorials',
  templateUrl: './tutorials.component.html',
  styleUrls: ['./tutorials.component.scss'],
  providers: [ToolbarService, LinkService, ImageService, HtmlEditorService, TableService , FormBuilder, CourseService ]

})

export class TutorialsComponent implements OnInit {
  public tools: object = {
    items: [
      'Bold', 'Italic', 'Underline', 'StrikeThrough', '|',
      'FontName', 'FontSize', 'FontColor', 'BackgroundColor', '|',
      'LowerCase', 'UpperCase', '|', 'Undo', 'Redo', '|',
      'Formats', 'Alignments', '|', 'OrderedList', 'UnorderedList', '|',
      'Indent', 'Outdent', '|', 'CreateLink','CreateTable',
      'Image', '|', 'ClearFormat', 'Print', 'SourceCode', '|', 'FullScreen']
  };

  public value: string = '';
  courses: CourseVto [] = [];

  formData = this.formBuilder.group({
    courseID: ['', Validators.required],
  });

  constructor(private formBuilder: FormBuilder, private  courseService: CourseService ) {
  }

  ngOnInit() {
    this.courseService.getAllInstructorCourses().subscribe(
      res => {
        this.courses = res;
        console.log(this.courses);
      }
    );
  }


}
