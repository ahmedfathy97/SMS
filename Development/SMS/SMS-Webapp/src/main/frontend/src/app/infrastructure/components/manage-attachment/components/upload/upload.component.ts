import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AttachmentService} from "../../shared/attachment.service";
import {FileVTO} from "../../shared/data/FileVTO";
import {AuthActions} from "../../../../directives/authorization/data/auth-actions.enum";
import {AngularFullRoutes, replaceCorID, replaceLecID} from "../../../../data/full-routes.enum";
import {ActivatedRoute} from "@angular/router";
import {CourseDataService} from "../../../../../modules/course/shared/services/course-data.service";
import {LectureService} from "../../../../../modules/course/shared/services/lecture.service";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css'],
  providers: [AttachmentService, LectureService]
})
export class UploadComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  replaceLecID = replaceLecID;

  lectureTitle;
  corID: number;
  lectureID: number;
  listOfFilesTable: boolean = false;
  popupCalender: boolean = false;

  filesVTO: FileVTO[] = [];

  constructor(private http: HttpClient,
              private service: AttachmentService,
              private lecService: LectureService,
              private corDataService: CourseDataService,
              private route: ActivatedRoute) {

    this.route.paramMap.subscribe(params => {
      this.lectureID = +params.get("lectureID");
      this.corID = +params.get("corID");

    });

    this.corDataService.corID.subscribe(
      data => {
        this.corID = data;
        console.log("inside Add Materials: " + this.corID);

      }
    );
    this.corDataService.requestCorID.next(true);
    this.getLectureData(this.lectureID);

  }

  ngOnInit() {
  }

  onFileSelected(event) {
    this.listOfFilesTable = true;
    // let fileList:File = event.target.files;
    let selectedFiles = event.target.files;

    for (let i = 0; i < selectedFiles.length; i++) {
      if (selectedFiles[i].name.length > 100) {
        console.log("File name is too long: " + selectedFiles[i].name);
        continue;
      }

      let name = selectedFiles[i].name.toString();
      let extension = selectedFiles[i].name.split('.').pop();
      let contentType = selectedFiles[i].type;
      let content = selectedFiles[i];
      let size = selectedFiles[i].size;
      let corID = this.corID;
      let sourceID = this.lectureID;

      let file: FileVTO = new FileVTO(0, name, contentType, extension, size, "", "", "",
        corID, sourceID, 0);
      file.content = selectedFiles[i];

      this.filesVTO.push(file);
    }
  }

  selectedOption(event, i) {
    this.filesVTO[i].fileSourceID = event.target.value;
    if (this.filesVTO[i].fileSourceID == 2) {
      this.popupCalender = true;
    }

  }

// sourceID : 1#for attachment , 2# assignment
  onUpload() {
    for (let i = 0; i < this.filesVTO.length; i++) {
      const fd = new FormData();
      fd.append("file", this.filesVTO[i].content);
      this.service.uploadFiles(fd, this.filesVTO[i], 0, 0);
    }
  }

  choosedDate(event, i, elementRef) {
    let date: string = event.chosenLabel.split('-');
    let startDate: string = date[0];
    let endDate: string = date[1];

    this.filesVTO[i].startDate = startDate;
    this.filesVTO[i].endDate = endDate;
    elementRef.click();
  }

  // remove file from list of upload files
  remove(id) {
    console.log(this.filesVTO[id].name + " file is removed");
    this.filesVTO.splice(id, 1);
  }

  // Conversion of size
  formatBytes(bytes, decimals) {
    if (bytes == 0) return '0 Bytes';
    var k = 1024,
      dm = decimals <= 0 ? 0 : decimals || 2,
      sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
      i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
  }

  getLectureData(lectureID: number) {
    this.lecService.getLectureData(lectureID).subscribe(res => {
      this.lectureTitle = res.title;
    }, err => {
      console.log(err);
    });
  }
}
