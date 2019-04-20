import {Component, OnInit} from '@angular/core';
import {AttachmentService} from "../../shared/attachment.service";
import {FileVTO} from "../../shared/data/FileVTO";

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css'],
  providers: [AttachmentService]
})
export class DownloadComponent implements OnInit {
  fileList: FileVTO[] = [];
  file:any;

  // change hard coded to dynamically
  filesRetrievalID:number = 1;
  constructor(private service: AttachmentService) {
  }

  ngOnInit() {
    this.retrieveFilesList(this.filesRetrievalID)}

  /*  id depends on the source  */
  retrieveFilesList(id:number){
      this.service.viewFiles(id).subscribe(
        res => this.fileList = res
      )
  }

  /*  Download by File ID  */
  download(fileID){
    // //   this.service.downloadFile(fileID).subscribe(data=>
    // //    this.file = data,//console.log(data),
    // //    error => console.log('Error downloading the file.'),
    // //      () => console.info('OK')
    // // );
    // this.service.downloadFile(fileID).subscribe(
    //   (response: any) =>{
    //     let dataType = response.type;
    //     let binaryData = [];
    //     binaryData.push(response);
    //     let downloadLink = document.createElement('a');
    //     downloadLink.href = window.URL.createObjectURL(new Blob(binaryData, {type: dataType}));
    //     // if (filename)
    //     //   downloadLink.setAttribute('download', filename);
    //     document.body.appendChild(downloadLink);
    //     downloadLink.click();
    //   }
    // )
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

}
