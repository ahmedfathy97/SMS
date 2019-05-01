import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../../../../../shared/services/user.service";
import {AngularFullRoutes, replaceUserID} from "../../../../../../../../../infrastructure/data/full-routes.enum";
import {UserVtoData} from "../../../../../../../shared/data/user-vto.data";
import {UserDataService} from "../../../../../../../shared/services/user-data.service";


// class ImageSnippet {
//
//   constructor(public src: string, public file: File) {}
// }
@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css'],
  providers:[FormBuilder,UserService]
})
export class UserEditComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceUserID =replaceUserID;


  //userID:string;
  // userID:string;

  private userEdit: UserVtoData = new UserVtoData();
  //userID: string;
  formData = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    age: ['', Validators.required],
    gender: ['', Validators.required],
    email: ['', Validators.required],
    phone: ['', Validators.required],
    userName: ['', Validators.required],

  });
   userID: number;
  private userVto: UserVtoData=new  UserVtoData();
  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
             private userDataService:UserDataService,
             /* private editService: EditData */
              private route: ActivatedRoute) {

    // this.route.paramMap.subscribe(params => {
    //   this.userID = +params.get("userID");
    // });
    // this.editService.userID.subscribe(
    //   data => {
    //     this.userID = data;
    //     console.log(data);
    //
    //   }
    // );
  }
    ngOnInit()
    {
      // this.route.paramMap.subscribe(params => {
      //   this.userID = +params.get("userID");
      //
      //
      //     var userID =+this.userID ;
      //   this.userService.findByID(this.userID).subscribe(
      //     res=> { this.userVto=res ;});
      //
      // })


      this.userDataService.userID.subscribe(
        data =>{
          this.userID = data;
          this.userService.findByID(this.userID).subscribe(

            res=> { this.userVto= res ;

            this.formData.get('firstName').reset(this.userVto.firstName);
            this.formData.get('lastName').reset(this.userVto.lastName);
              this.formData.get('age').reset(this.userVto.age);
              this.formData.get('email').reset(this.userVto.email);
              this.formData.get('phone').reset(this.userVto.phone);
              this.formData.get('userName').reset(this.userVto.userName);
              this.formData.get('gender').reset(this.userVto.gender);


            });
        }
      );
      this.userDataService.requestUserID.next(true);
    }
    onSaveEdit()
    {
      let userEdit: UserVtoData = new UserVtoData();
      userEdit.firstName = this.formData.get('firstName').value;
      userEdit.lastName = this.formData.get('lastName').value;
      userEdit.age = this.formData.get('age').value;
      userEdit.gender = this.formData.get('gender').value;
      userEdit.email = this.formData.get('email').value;
      userEdit.userName = this.formData.get('userName').value;
      userEdit.phone=this.formData.get('phone').value;
      console.log(userEdit);
      this.userService.editProfile(this.userID, userEdit).subscribe(res => {
        console.log("Success");
      }, err => {
        console.log(err);
      });

    }

}
