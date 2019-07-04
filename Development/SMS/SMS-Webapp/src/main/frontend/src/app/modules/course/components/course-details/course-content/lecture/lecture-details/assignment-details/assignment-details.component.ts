import {Component, OnInit, ViewChild} from '@angular/core';
import {AuthActions} from "../../../../../../../../infrastructure/directives/authorization/data/auth-actions.enum";
import {AngularFullRoutes, replaceCorID} from "../../../../../../../../infrastructure/data/full-routes.enum";
import {CourseDataService} from "../../../../../../shared/services/course-data.service";
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../../../../../../shared/services/course.service";
import {DownloadComponent} from "../../../../../../../../infrastructure/components/manage-attachment/components/download/download.component";
import {AssignmentService} from "./shared/assignment.service";
import {Assignment} from "./shared/data/Assignment";
import {AttachmentService} from "../../../../../../../../infrastructure/components/manage-attachment/shared/attachment.service";

@Component({
  selector: 'app-assignment-details',
  templateUrl: './assignment-details.component.html',
  styleUrls: ['./assignment-details.component.css'],
  providers: [CourseService, AssignmentService]
})
export class AssignmentDetailsComponent implements OnInit {
  AUTH_ACTIONS: typeof AuthActions = AuthActions;
  ROUTES: typeof AngularFullRoutes = AngularFullRoutes;
  replaceCorID = replaceCorID;
  corID: number;
  lecID: number;

  assignments: Assignment[] = [];
  @ViewChild("component1") downloadComponent: DownloadComponent;


  constructor(private corDataService: CourseDataService,
              private courseService: CourseService,
              private route: ActivatedRoute,
              private assignmentService: AssignmentService,
              private service: AttachmentService) {
    this.corDataService.corID.subscribe(
      data => {
        this.corID = data;
      });
    this.corDataService.requestCorID.next(true);
  }
  
  corName: string;
  ngOnInit() {
    this.courseService.getCourseByID(this.corID).subscribe(res => this.corName = res.courseName);
    this.assignmentService.getListAssignmentStudent(1, 1).subscribe(res => this.assignments = res,
      error => {
      }
    );
  }

  download(fileID) {
    //   this.service.downloadFile(fileID).subscribe(data=>
    //    this.file = data,//console.log(data),
    //    error => console.log('Error downloading the file.'),
    //      () => console.info('OK')
    // // );
    this.service.downloadFile(fileID).subscribe(
      (response: any) => {
        let name = response.toString();
        console.log("try of name: " + name)
        let dataType = response.type;
        let binaryData = [];
        binaryData.push(response);
        let downloadLink = document.createElement('a');
        downloadLink.href = window.URL.createObjectURL(new Blob(binaryData, {type: dataType}));
        if ("file")
          downloadLink.setAttribute('download', "file");
        document.body.appendChild(downloadLink);
        downloadLink.click();
      }
    )
  }
}
