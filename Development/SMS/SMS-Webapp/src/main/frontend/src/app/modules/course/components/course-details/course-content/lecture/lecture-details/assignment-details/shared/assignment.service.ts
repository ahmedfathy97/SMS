import {Injectable} from '@angular/core';
import {ConfigParam} from "../../../../../../../../../infrastructure/common/config-param";
import {Assignment} from "./data/Assignment";
import {HttpClient, HttpParams} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {
  assignment: Assignment;
  BASE_URL: string = ConfigParam.APP_BASE_URL + "/assignment";

  constructor(private http: HttpClient) {
  }

  getListAssignmentStudent(corID: number, lecID: number) {
    const params = new HttpParams()
      .set("corID", corID.toString())
      .set("lecID", lecID.toString())

    return this.http.get<Assignment[]>(this.BASE_URL + '/list', {params: params});

  }
}
