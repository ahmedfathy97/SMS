import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseDTO} from "../../shared/data/course/course-dto.data";
import {CorCategory} from "../../shared/data/lookup/course/cor-category.data";
import {CorLevel} from "../../shared/data/lookup/course/cor-level.data";
import {CorType} from "../../shared/data/lookup/course/cor-type.data";
import {CourseService} from "../../shared/services/course.service";
import {LookupService} from "../../../../infrastructure/services/lookup.service";

@Component({
  selector: 'app-course-details',
  templateUrl: './create-course.component.html',
  providers: [CourseService, LookupService]
})
// TODO: Youssef - rename to CreateCourse
// TODO: Youssef - move component to /modules/course/components/create-course
export class CreateCourse implements OnInit {
  // TODO: Youssef - rename to corCategoryList remember changes in html
  corCategoryList: CorCategory[] = [];
  // TODO: Youssef - rename to corTypeList remember changes in html
  corTypeList: CorType[] = [];
  // TODO: Youssef - rename to corLevelList remember changes in html
  corLevelList: CorLevel[] = [];


  constructor(private formBuilder: FormBuilder,
              // TODO: Youssef - rename to corService
              private corService: CourseService,
              // TODO: Youssef - rename to lookupService
              private lookupService: LookupService) {

  }

  ngOnInit() {
    //TODO: YOussef - Check these lines again
    this.lookupService.findCorCategory().subscribe(res => {
      this.corCategoryList = res;
    });
    this.lookupService.findCorType().subscribe(res => {
      this.corTypeList = res;
    });
    this.lookupService.findCorLevel().subscribe(res => {
      this.corLevelList = res;
    });

  }



  formData: FormGroup = this.formBuilder.group({
    courseName: [null, [Validators.required, Validators.maxLength(25)]],
    duration: [null, [Validators.required, Validators.min(1)]],
    startDate: [null, [Validators.required]],
    endDate: [null, [Validators.required]],
    categoryID: [null, Validators.required],
    typeID: [null, Validators.required],
    levelID: [null, Validators.required],
    description: [null, [Validators.maxLength(200)]]
  });

  // TODO: Youssef - onSubmitNewCourse
  onSubmitNewCourse() {
    let details: CourseDTO = new CourseDTO();

    details.courseName = this.formData.get('courseName').value;
    details.duration = this.formData.get('duration').value;
    details.startDate = this.formData.get('startDate').value;
    details.endDate = this.formData.get('endDate').value;
    details.categoryID = this.formData.get('categoryID').value;
    details.typeID = this.formData.get('typeID').value;
    details.levelID = this.formData.get('levelID').value;
    details.description = this.formData.get('description').value;

    this.corService.createNewCourse(details).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }

}
