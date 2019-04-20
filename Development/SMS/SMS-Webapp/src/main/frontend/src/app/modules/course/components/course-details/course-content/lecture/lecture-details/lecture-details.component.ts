import { Component, OnInit } from '@angular/core';
import {DownloadComponent} from "../../../../../../../infrastructure/components/manage-attachment/components/download/download.component";
import {AttachmentService} from "../../../../../../../infrastructure/components/manage-attachment/shared/attachment.service";
import {FileVTO} from "../../../../../../../infrastructure/components/manage-attachment/shared/data/FileVTO";

@Component({
  selector: 'app-lecture-details',
  templateUrl: './lecture-details.component.html',
  styleUrls: ['./lecture-details.component.css']
})
export class LectureDetailsComponent implements OnInit {
  lectureTitle:string = "Lecture 1";
  // change to dynamic
  sourceID:number = 1;

  attachments:FileVTO[] = [];
  assignments: FileVTO[] = [];

  constructor(private fileService: AttachmentService) { }

  ngOnInit() {
    this.retrieveFilesList(this.sourceID, this.attachments);
    this.retrieveFilesList(this.sourceID, this.assignments);
  }

  /*  id depends on the source  */
  retrieveFilesList(sourceID:number, fileList){
    // change id according to topic section
    this.fileService.viewFiles(sourceID).subscribe(
      res => fileList = res
    )
  }

}
