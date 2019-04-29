import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../../../../../shared/services/course.service";
import {GradeService} from "../../../../../shared/services/grade.service";
import {CourseVto} from "../../../../../shared/data/course-vto";
import {StdDTO} from "../../../../../shared/data/std-dto.data";
import {ActivatedRoute, Router} from "@angular/router";
import {CourseDataService} from "../../../../../shared/services/course-data.service";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../infrastructure/data/full-routes.enum";
import {LocalStorageService} from "../../../../../../../infrastructure/services/local-storage.service";


@Component({
  selector: 'app-create-grade',
  templateUrl: './create-grade.component.html',
  styleUrls: ['./create-grade.component.scss'],
  providers: [FormBuilder,CourseService ,GradeService]
})
export class CreateGradeComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;

  corID :number ;
  stdID: number;
  // gradeType:number;
  formData: FormGroup = this.formBuilder.group({
    course: [null, [Validators.required]],
    items: new FormArray([]),
    gradeType:[null, [Validators.required]]
  });

  constructor(private formBuilder: FormBuilder,
              private courseService: CourseService,
              private corDataService: CourseDataService,
              private router: Router, private localStorageSerice: LocalStorageService,

              private gradeService:GradeService , private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.stdID = +params.get("stdID");
    });


    this.corDataService.corID.subscribe(
      data =>{
        this.corID = data;
        this.getCourseStudents();


  });
    this.corDataService.requestCorID.next(true);
  }
  getCourseStudents(){
    this.courseService.getAllCourseStudents(this.corID, this.formData.get('gradeType').value, null).subscribe(
      res => {
        this.students = res;
        this.clearFormArray(this.items);

        for(let i=0; i<this.students.length; i++) {
          if(this.formData.get("gradeType").value=='M1') {
            this.addItem(this.students[i].midTermOne);

          }else if (this.formData.get("gradeType").value=='SF') {
            this.addItem(this.students[i].semiFinal);
          }
          else if (this.formData.get("gradeType").value=='M2') {
            this.addItem(this.students[i].midTermTwo);
          }else
            this.addItem(this.students[i].finalGrd)

        }
        // this.courseSelected=true;


      }
    )

  }
  // courses: CourseVto [] = [];
  // courseSelected:boolean=false;

  students: StdDTO[] = [];

  ngOnInit() {
    // var courseID = +this.courseID;
    // this.corID = courseID ;
    // this.courseService.getAllInstructorCourses().subscribe(
    //   res => {
    //     this.courses = res;
    //     console.log(this.courses);
    //   }
    // );
    // debugger;



  }

  // onChangeType() {
  //   console.log();
  //
  //
  // }

  onSubmitGradeSheet() {

    for(let i=0; i<this.students.length; i++)
      this.students[i].newGrade = this.items.at(i).get('grade').value;

    let gradeType: string = this.formData.get('gradeType').value;

    console.log(this.students);
    this.gradeService.createNewGradeSheet(this.corID,this.students,gradeType).subscribe(
      res=> {
        // console.log('request succed')
        this.router.navigate([`/course/${this.corID}/grade`])

      },
      error1 => {
        console.log(error1)
      }
    );


  }

  private get items(): FormArray {
    return this.formData.get('items') as FormArray;
  }

  private addItem(grade:number): void {
    this.items.push(this.formBuilder.group({
      grade: grade,

    }));
    // this.formData.reset();
  }
  clearFormArray = (formArray: FormArray) => {
    while (formArray.length !== 0) {
      formArray.removeAt(0)
    }
  }
}





