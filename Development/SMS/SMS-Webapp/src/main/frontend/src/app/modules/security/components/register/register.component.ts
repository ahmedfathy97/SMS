import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SecurityService} from "../../shared/security.service";
import {RegisterDTO} from "../../shared/data/register-dto.data";
import {RolesVto} from "../../shared/data/roles-Vto";
import {AngularFullRoutes} from "../../../../infrastructure/data/full-routes.enum";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {LocalStorageService} from "../../../../infrastructure/services/local-storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [FormBuilder, SecurityService]
})
export class RegisterComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
   roleList : RolesVto[] ;
  formData: FormGroup = this.formBuilder.group({
    firstName: [null , [Validators.required ,Validators.maxLength(15),Validators.minLength(3)] ],
    lastName: [null , [Validators.required ,Validators.maxLength(15),Validators.minLength(3)] ],
    username: [null , [Validators.required ,Validators.maxLength(25)]],
    password: [null , [Validators.required ,Validators.minLength(8)]],
    confirmPassword: [null , [Validators.required ,Validators.minLength(8)]],
    email: [null,[Validators.required,Validators.maxLength(30), Validators.pattern('^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$')]] ,
    roleType :[null,Validators.required] ,
    birthDate : [null,Validators.required]  ,
    phone:[null,Validators.required]  ,
    gender:[null,Validators.required]  ,
  });
  get regisretForm() { return this.formData.controls; }

  constructor(private formBuilder: FormBuilder,
              private securityService: SecurityService ,
              private router: Router) { }

  ngOnInit() {
    this.securityService.getAllRoles().subscribe(res => {
      this.roleList = res;
    }, err => {
      console.log(err);
    });
  }

  onSubmit(){
    ConfigParam.markControlsDirty(this.formData);

    if(this.formData.valid) {
      let data: RegisterDTO = new RegisterDTO();
      data.roleID = this.formData.get('roleType').value;
      data.firstName = this.formData.get('firstName').value;
      data.lastName = this.formData.get('lastName').value;
      data.username = this.formData.get('username').value;
      data.password = this.formData.get('password').value;
      data.email = this.formData.get('email').value;
      data.birthDate =this.formData.get('birthDate').value;
      data.gender = this.formData.get('gender').value;
      data.phone =this.formData.get('phone').value;
      this.securityService.register(data).subscribe(
        res => {
          this.router.navigate([this.ROUTES.LOGIN]);
        },
        err => {
          console.log(err);
        }
      );
    }
  }


  onclickoption($event)
  {


  }

}
