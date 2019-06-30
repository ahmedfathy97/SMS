import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Announcement} from "../data/announcment";
import {ConfigParam} from "../../../../infrastructure/common/config-param";

@Injectable()
export class AnnouncementService {
  // BASE_URL: string = "http://localhost:8080/api/announcment/";
  BASE_URL: string = ConfigParam.APP_BASE_URL+"/announcment/";


  constructor(private http: HttpClient) {
  }

  createNewAnnouncement(courseID: number, announcement : Announcement) {
    return this.http.post(this.BASE_URL + courseID +"/new", announcement);
  }

}
