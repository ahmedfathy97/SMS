import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {LocalStorageService} from "../../infrastructure/services/local-storage.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isUserAuthenticated: boolean = false;

  constructor(private localStorageService: LocalStorageService) {
    this.isUserAuthenticated = (this.localStorageService.getCurrentUser() != null
      && this.localStorageService.getCurrentUser().token != null);
  }

  ngOnInit() {
  }

}
