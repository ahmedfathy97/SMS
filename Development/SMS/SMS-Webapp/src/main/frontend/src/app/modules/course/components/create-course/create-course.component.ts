import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseDTO} from "../../shared/data/course/course-dto.data";
import {CorCategory} from "../../shared/data/lookup/course/cor-category.data";
import {CorLevel} from "../../shared/data/lookup/course/cor-level.data";
import {CorType} from "../../shared/data/lookup/course/cor-type.data";
import {CourseService} from "../../shared/services/course.service";
import {LookupService} from "../../../../infrastructure/services/lookup.service";
import {AngularFullRoutes} from "../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'app-course-details',
  templateUrl: './create-course.component.html',
  providers: [CourseService, LookupService]
})

export class CreateCourse implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;

  corCategoryList: CorCategory[] = [];
  corTypeList: CorType[] = [];
  corLevelList: CorLevel[] = [];


  constructor(private formBuilder: FormBuilder,
              private corService: CourseService,
              private lookupService: LookupService) {

  }

  ngOnInit() {
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


  submitted = false;

  formData: FormGroup = this.formBuilder.group({
    courseName: [null, [Validators.required, Validators.maxLength(25)]],
    duration: [null, [Validators.required, Validators.min(1)]],
    startDate: [null, [Validators.required]],
    endDate: [null, [Validators.required]],
    categoryID: [null, Validators.required],
    typeID: [null, Validators.required],
    levelID: [null, Validators.required],
    description: [null, [Validators.maxLength(500)]]
  });

  // convenience getter for easy access to form fields
  get f() { return this.formData.controls; }

  onSubmitNewCourse() {
    this.submitted = true;
    this.formData.get('courseName').markAsDirty();
    this.formData.get('duration').markAsDirty();
    this.formData.get('startDate').markAsDirty();
    this.formData.get('endDate').markAsDirty();
    this.formData.get('categoryID').markAsDirty();
    this.formData.get('typeID').markAsDirty();
    this.formData.get('levelID').markAsDirty();
    this.formData.get('description').markAsDirty();



    // stop here if form is invalid
    if (!this.formData.invalid) {
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

}
