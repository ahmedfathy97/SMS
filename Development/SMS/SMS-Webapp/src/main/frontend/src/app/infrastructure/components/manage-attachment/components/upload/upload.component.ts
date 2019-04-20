import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AttachmentService} from "../../shared/attachment.service";
import {FileVTO} from "../../shared/data/FileVTO";

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css'],
  providers: [AttachmentService]
})
export class UploadComponent implements OnInit {

  // files:FileList;
  files: Array<File> = [];

  constructor(private http: HttpClient, private service: AttachmentService) {
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

  onUpload() {
    const fd = new FormData();
    for (let i = 0; i < this.files.length; i++) {
      let file = this.files[i];
      let size: number = this.files[i].size;
      let type: string = file.type;
      let extension: string = file.name.split('.').pop();
      let name: string = file.name;
      // console.log(file)
      fd.append("file", file);
      this.service.uploadFiles(fd, name, type, size, extension);
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
