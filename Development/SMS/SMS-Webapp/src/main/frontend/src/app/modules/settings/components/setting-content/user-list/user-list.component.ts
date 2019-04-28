import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
//import {UserService} from "../../../../user/shared/user.service";
import {College} from "../../../shared/data/college";
import {University} from "../../../shared/data/university";
import {Country} from "../../../shared/data/country";
import {UserVtoData} from "../../../shared/data/user-vto.data";
import {AngularFullRoutes, replaceUserID} from "../../../../../infrastructure/data/full-routes.enum";
import {UserService} from "../../../shared/services/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers:[FormBuilder,UserService]
})
export class UserListComponent implements OnInit {

  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceUserID =replaceUserID;

  userList:UserVtoData[]=[];
  formData :FormGroup=this.formBuilder.group({
    fullname:[null,[Validators.required,Validators.maxLength(20)]],
    college:[null,[Validators.required]],
    university:[null,[Validators.required]],
    country:[null,[Validators.required]],
    birthdatefrom:[null,[Validators.required]],
    birthdateto:[null,[Validators.required]],
  })
  public collegeArrayList :College[];
  public universityArrayList:University[];
  public countryArrayList:Country[];


  constructor( private formBuilder:FormBuilder ,private userService:UserService) { }

  ngOnInit() {
    this.userService.findAll().subscribe(
      res=> this.userList=res
    )
  }
  // filter(){
  //   let data : UserVtoData =new UserVtoData();
  //  data.firstName=this.formData.get('firstname').value;
  //   data.lastName=this.formData.get('lastname').value;
  //   data.email=this.formData.get('email').value;
  //   data.userName=this.formData.get('username').value;
  //   data.password=this.formData.get('password').value;
  //
  //
  //   console.log(data);
  //
  //   this.userService.filter(data).subscribe(
  //     res=>
  //     {
  //       console.log('Request Succeeded');
  //     },
  //     err=>
  //     {
  //       console.log(err);
  //     }
  //   );
  // }



  // findallcollege(){
  //   let col_data: College=new College();
  //   col_data.id=this.formData.get('id').value;
  //   col_data.labelEN=this.formData.get('labelEN').value;
  //   console.log(col_data);
  //   this.userService.findallcollege().subscribe(res =>
  //   {
  //     console.log(res);
  //     this.collegeArrayList=res;
  //   })
  // }
  // findalluniversity(){
  //   let uni_data: University=new University();
  //   uni_data.id=this.formData.get('id').value;
  //   uni_data.labelEN=this.formData.get('labelEN').value;
  //   console.log(uni_data);
  //
  //   this.userService.findalluniversity().subscribe(res=> {
  //     console.log(res);
  //     this.universityArrayList=res;
  //
  //   })
  // }
  // findallcountry(){
  //   let co_data: Country=new Country();
  //   co_data.id=this.formData.get('id').value;
  //   co_data.labelEN=this.formData.get('labelEN').value;
  //   console.log(co_data);
  //
  //   this.userService.findallcountry().subscribe(res=> {
  //     console.log(res);
  //     this.countryArrayList = res;
  //
  //
  //   })
  //
  // }
  // clear(): void {
  //   this.formData.reset();
  // }
}
