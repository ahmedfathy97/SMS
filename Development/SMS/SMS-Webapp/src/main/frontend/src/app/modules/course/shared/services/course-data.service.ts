import { Injectable } from '@angular/core';
import {Subject} from "rxjs/internal/Subject";

@Injectable()
export class CourseDataService {

  corID = new Subject<number>();
  requestCorID = new Subject<boolean>();
  constructor() { }
}
