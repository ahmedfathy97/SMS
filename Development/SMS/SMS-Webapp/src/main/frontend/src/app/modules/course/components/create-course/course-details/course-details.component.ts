import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseDetailsData} from "../../../shared/data/course/course-details.data";
import {CourseService} from "../../../shared/course.service";
import {LookupService} from "../../../../../layout/shared/service/lookup.service";
import {CorDetailsCategoryData} from "../../../shared/data/lookup/course/cor-details-category.data";
import {CorDetailsLevelData} from "../../../shared/data/lookup/course/cor-details-level.data";
import {CorDetailsTypeData} from "../../../shared/data/lookup/course/cor-details-type.data";

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  providers: [CourseService, LookupService]
})
// TODO: Youssef - rename to CreateCourse
// TODO: Youssef - move component to /modules/course/components/create-course
export class CourseDetailsComponent implements OnInit {
  // TODO: Youssef - rename to corCategoryList remember changes in html
  corCategory: CorDetailsCategoryData[] = [];
  // TODO: Youssef - rename to corTypeList remember changes in html
  corType: CorDetailsTypeData[] = [];
  // TODO: Youssef - rename to corLevelList remember changes in html
  corLevel: CorDetailsLevelData[] = [];


  constructor(private formBuilder: FormBuilder,
              // TODO: Youssef - rename to corService
              private service: CourseService,
              // TODO: Youssef - rename to lookupService
              private lookUp: LookupService) {

  }

  ngOnInit() {
    //TODO: YOussef - Check these lines again
    // this.lookUp.findCorCategory().subscribe(res => {
    //   this.corCategory = res;
    // });
    // this.lookUp.findCorType().subscribe(res => {
    //   this.corType = res;
    // });
    // this.lookUp.findCorLevel().subscribe(res => {
    //   this.corLevel = res;
    // });

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
  addCourseData() {
    let details: CourseDetailsData = new CourseDetailsData();

    details.courseName = this.formData.get('courseName').value;
    details.duration = this.formData.get('duration').value;
    details.startDate = this.formData.get('startDate').value;
    details.endDate = this.formData.get('endDate').value;
    details.categoryID = this.formData.get('categoryID').value;
    details.typeID = this.formData.get('typeID').value;
    details.levelID = this.formData.get('levelID').value;
    details.description = this.formData.get('description').value;

    this.service.addCourseData(details).subscribe(res => {
      console.log("Success");
    }, err => {
      console.log(err);
    });
  }

}
