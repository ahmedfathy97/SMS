import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../../../../../shared/services/user.service";
import {AngularFullRoutes, replaceUserID} from "../../../../../../../../../infrastructure/data/full-routes.enum";
import {UserVtoData} from "../../../../../../../shared/data/user-vto.data";
import {UserDataService} from "../../../../../../../shared/services/user-data.service";
import {ConfigParam} from "../../../../../../../../../infrastructure/common/config-param";


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

  private userEdit: UserVtoData = new UserVtoData();
  //userID: string;
  formData = this.formBuilder.group({
    firstName: ['', [Validators.required,Validators.maxLength(15),Validators.minLength(3)]],
    lastName: ['',[ Validators.required,Validators.maxLength(15),Validators.minLength(3)]],
    birthDate: ['', Validators.required,Validators.pattern('^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$')],
    gender: ['', Validators.required],
    email: ['', [Validators.required,Validators.maxLength(30), Validators.pattern('^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$')]],
    t_phone: ['', [Validators.required,Validators.maxLength(11)]],
    userName: ['',[Validators.required,Validators.maxLength(25)]],

  });

  get edit() { return this.formData.controls; }
   userID:number;
  private userVto: UserVtoData=new  UserVtoData();
  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
             private userDataService:UserDataService,
             /* private editService: EditData */
              private route: ActivatedRoute) {
  }
    ngOnInit()
    {



      this.userDataService.userID.subscribe(
        data =>{
          this.userID = data;
          this.userService.findByID(this.userID).subscribe(

            res=> { this.userVto= res ;

              this.formData.get('firstName').reset(this.userVto.firstName);
              this.formData.get('lastName').reset(this.userVto.lastName);
              this.formData.get('birthDate').reset(this.userVto.birthDate);
              this.formData.get('gender').reset(this.userVto.gender);
              this.formData.get('email').reset(this.userVto.email);
              this.formData.get('t_phone').reset(this.userVto.phone);
              this.formData.get('userName').reset(this.userVto.userName);



            });
        }
      );
      this.userDataService.requestUserID.next(true);
    }
    onSaveEdit()
    {
      // this.edit.firstName.markAsDirty();
      // this.edit.lastName.markAsDirty();
      // this.edit.age.markAsDirty();
      ConfigParam.markControlsDirty(this.formData);

      if(this.formData.valid) {
        let userEdit: UserVtoData = new UserVtoData();
        userEdit.firstName = this.formData.get('firstName').value;
        userEdit.lastName = this.formData.get('lastName').value;
        userEdit.birthDate = this.formData.get('birthDate').value;
        userEdit.gender = this.formData.get('gender').value;
        userEdit.email = this.formData.get('email').value;
        userEdit.userName = this.formData.get('userName').value;
        userEdit.phone = this.formData.get('t_phone').value;

        this.userService.editProfile(this.userID, userEdit).subscribe(res => {
          console.log("Success");
        }, err => {
          console.log(err);
        });
      }
    }



}
