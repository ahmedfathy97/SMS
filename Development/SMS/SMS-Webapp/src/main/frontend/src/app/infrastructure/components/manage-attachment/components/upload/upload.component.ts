import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AttachmentService} from "../../shared/attachment.service";
import {FileVTO} from "../../shared/data/FileVTO";
import {AuthActions} from "../../../../directives/authorization/data/auth-actions.enum";
import {AngularFullRoutes, replaceCorID} from "../../../../data/full-routes.enum";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css'],
  providers: [AttachmentService]
})
export class UploadComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID: number ;
  lectureID: number;


  // files:FileList;
  files: Array<File> = [];

  constructor(private http: HttpClient, private service: AttachmentService,
              private route: ActivatedRoute) {
    this.route.paramMap.subscribe(params => {
      this.lectureID = +params.get("lectureID");
      this.corID = +params.get("corID");

    });
    console.log("inside upload: ")
    console.log("LectureDetails: "+ this.lectureID)
    console.log("corID: "+ this.corID)

      }


  ngOnInit() {
  }


  onFileSelected(event) {
    // let fileList:File = event.target.files;
    let selectedFiles = event.target.files;

    for (let i = 0; i < selectedFiles.length; i++) {
      if (selectedFiles[i].name.length > 60) {
        console.log("File name is too long: " + selectedFiles[i].name);
        continue;
      }
      this.files.push(selectedFiles[i]);
      // console.log(this.files[i].name+" / " + this.files[i].name.length);

    }
  }
// sourceID : 1#for attachment , 2# assignment
  onUpload(sourceID, fileSrcID) {
    const fd = new FormData();
    for (let i = 0; i < this.files.length; i++) {
      let file = this.files[i];
      let size: number = this.files[i].size;
      let type: string = file.type;
      let extension: string = file.name.split('.').pop();
      let name: string = file.name;

      fd.append("file", file);
      this.service.uploadFiles(fd, name, type, size, extension, 1, 1);
    }

    // this.service.uploadFiles(fd)

  }

  delete(id) {
    console.log(this.files[id].name + " file is removed");
    this.files.splice(id, 1);
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


}
