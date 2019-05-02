import { Injectable } from '@angular/core';
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LectureDataService {
  lecID$ = new Subject<number>();
  requestLecID$ = new Subject<boolean>();

  constructor() { }
}
