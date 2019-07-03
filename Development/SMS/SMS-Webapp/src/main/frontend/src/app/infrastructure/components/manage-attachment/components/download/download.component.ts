import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {AttachmentService} from "../../shared/attachment.service";
import {FileVTO} from "../../shared/data/FileVTO";
import {AuthActions} from "../../../../directives/authorization/data/auth-actions.enum";
import {AngularFullRoutes} from "../../../../data/full-routes.enum";
import {CourseDataService} from "../../../../../modules/course/shared/services/course-data.service";
import {inputs} from "@syncfusion/ej2-angular-richtexteditor/src/rich-text-editor/richtexteditor.component";
import {LocalStorageService} from "../../../../services/local-storage.service";

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css'],
  providers: [AttachmentService]
})
export class DownloadComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;

  @Input("sourceID") sourceID;
  @Input("fileSrcID") fileSrcID;
  @Input("corID") corID;

  assignmentUploadStatus: boolean = false;

  fileList: FileVTO[] = [];
  file:any;
  userID: number;


  constructor(private service: AttachmentService,
              private corDataService: CourseDataService,
              private localStorageService: LocalStorageService) {
    this.corDataService.corID.subscribe(
      data => {
        this.corID = data;
      }
    );
    this.corDataService.requestCorID.next(true);
    this.userID = this.localStorageService.getCurrentUser().userID;

  }

  ngOnInit() {
    console.log("download corID: " + this.corID)
    this.retrieveFilesList(this.corID, this.sourceID, this.fileSrcID);
  }

  retrieveFilesList(corID: number, sourceID: number, fileSrcID: number) {
    this.service.viewFiles(corID, sourceID, fileSrcID).subscribe(res => {
        this.fileList = res;
        console.log(this.fileList);
      })
    return this.fileList;
  }

  /*  Download by File ID  */
  download(fileID, fileName, type){
    //   this.service.downloadFile(fileID).subscribe(data=>
    //    this.file = data,//console.log(data),
    //    error => console.log('Error downloading the file.'),
    //      () => console.info('OK')
    // // );
    this.service.downloadFile(fileID).subscribe(
      (response: any) =>{
        let dataType = response.type;
        let binaryData = [];
        binaryData.push(response);
        let downloadLink = document.createElement('a');
        downloadLink.href = window.URL.createObjectURL(new Blob(binaryData, {type: dataType}));
        if (fileName)
          downloadLink.setAttribute('download', fileName);
        document.body.appendChild(downloadLink);
        downloadLink.click();
      }
    )
  }

  /* Delete Files */
  deleteFile(fileID:number){
  }


  /* Format of file size */
  formatBytes(bytes, decimals) {
    if (bytes == 0) return '0 Bytes';
    var k = 1024,
      dm = decimals <= 0 ? 0 : decimals || 2,
      sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
      i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
  }

  uploadAssignmentAnswer(event, assignmentID) {
    let file: File = event.target.files[0];
    const fd = new FormData();
    fd.append("file", file);

    let name = file.name;
    let extension = file.name.split('.').pop();
    let contentType = file.type;
    let size = file.size;
    let corID = this.corID;
    let sourceID = this.sourceID;

    let fileVTO: FileVTO = new FileVTO(0, name, contentType, extension, size, "", "", "",
      corID, sourceID, 3);

    this.service.uploadFiles(fd, fileVTO, this.userID, assignmentID);
  }
}


















