import { Component, OnInit } from '@angular/core';
import {UserData} from "../../shared/data/user-data";
import {UserService} from "../../shared/user.service";

import {FormBuilder, Validators} from "@angular/forms";
import {EditData} from "../../shared/data/edit-data";
import {ActivatedRoute} from "@angular/router";


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

  private userEdit: UserData = new UserData();
  //userID: string;
  formData = this.formBuilder.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    age: ['', Validators.required],
    gender: ['', Validators.required],
    email: ['', Validators.required],
    phone: ['', Validators.required],
    college: ['', Validators.required],
    userName: ['', Validators.required],

  });
  userID: number;

  constructor(private userService: UserService,
              private formBuilder: FormBuilder,
              private editService: EditData,
              private route: ActivatedRoute) {

    this.route.paramMap.subscribe(params => {
      this.userID = +params.get("userID");
    });
    this.editService.userID.subscribe(
      data => {
        this.userID = data;
        console.log(data);

      }
    );
  }
    ngOnInit()
    {
      // var userID = +this.userID;
      // this.userService.findByID(userID).subscribe(
      //   res => {
      //     this.userData = res;
      //   });
    }
    onSaveEdit()
    {
      let userEdit: UserData = new UserData();
      userEdit.firstName = this.formData.get('firstName').value;
      userEdit.lastName = this.formData.get('lastName').value;
      userEdit.age = this.formData.get('age').value;
      userEdit.gender = this.formData.get('gender').value;
      userEdit.e_mail = this.formData.get('e_mail').value;
      userEdit.college = this.formData.get('college').value;
      userEdit.userName = this.formData.get('userName').value;
      console.log(userEdit);
      this.userService.editProfile(this.userID).subscribe(res => {
        console.log("Success");
      }, err => {
        console.log(err);
      });

    }


}
