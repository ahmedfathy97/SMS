import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from '@angular/router';
import {SecurityService} from "../../shared/security.service";
import {LoginDTO} from "../../shared/data/login-dto.data";
import {AuthUserVTO} from "../../shared/data/auth-user-vto.data";
import {LocalStorageService} from "../../../../infrastructure/services/local-storage.service";
import {AlertInput} from "../../../../infrastructure/components/alerts/alert-input";
import {FailureAlert} from "../../../../infrastructure/components/alerts/failure-alert.data";
import {ConfigParam} from "../../../../infrastructure/common/config-param";
import {SuccessAlert} from "../../../../infrastructure/components/alerts/success-alert.data";
import {AngularFullRoutes} from "../../../../infrastructure/data/full-routes.enum";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [FormBuilder, SecurityService]
})
export class LoginComponent implements OnInit {
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;

  formData: FormGroup = this.formBuilder.group({
    username: [null , Validators.required],
    password: [null , Validators.required ]
  });

  get loginForm() { return this.formData.controls; }
  alert: AlertInput = new AlertInput();
  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private securityService: SecurityService,
              private localStorageService: LocalStorageService) { }

  ngOnInit() {
  }

  onLogin() {
    ConfigParam.markControlsDirty(this.formData);
    if (this.formData.valid) {
      let data: LoginDTO = new LoginDTO();
      data.username = this.formData.get('username').value;
      data.password = this.formData.get('password').value;
      this.securityService.login(data).subscribe(
        res => {
          // let authUser: AuthUserVTO = new AuthUserVTO();
          // authUser = res;
          console.log('Login Successfully');
          this.alert = new SuccessAlert();
          this.router.navigate(['/courses']);
          this.localStorageService.setAuthUser(res);
        },

        err => {console.log(err);
          this.alert = new FailureAlert(err);
        });
    }
  }
}
