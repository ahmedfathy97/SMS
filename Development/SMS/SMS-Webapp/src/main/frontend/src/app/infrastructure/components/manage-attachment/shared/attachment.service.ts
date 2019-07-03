import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule, HttpHeaders, HttpParams} from "@angular/common/http";
import {FileVTO} from "./data/FileVTO"
import {Observable} from "rxjs";
import {ConfigParam} from "../../../common/config-param";

@Injectable({
  providedIn: 'root'
})
export class AttachmentService {

  file: FileVTO;
  BASE_URL: string = ConfigParam.APP_BASE_URL+"/attachment";

  constructor(private http: HttpClient) {
  }

  // Upload files to server
  uploadFiles(fd: FormData, file: FileVTO) {

    const params = new HttpParams()
      .set("name", file.name)
      .set("type", file.contentType)
      .set("size", file.size.toString())
      .set("ext", file.extension)
      .set("sourceID", file.sourceID.toString())
      .set("fileSrcID", file.fileSourceID.toString())
      .set("corID", file.corID.toString())
      .set("startDate", file.startDate)
      .set("endDate", file.endDate)

    this.http.post(this.BASE_URL + "/file", fd, {params: params})
      .subscribe(res => {
          console.log(res);
        }
        ,
        err => {
          console.log(err.message);
        }
      )
  }

  /* Retrieve List of files */
  viewFiles(corID, sourceID, fileSrcID) {
    const params = new HttpParams()
      .set("corID", corID)
      .set("sourceID", sourceID)
      .set("fileSrcID", fileSrcID)

    return this.http.get<FileVTO[]>(this.BASE_URL + '/files', {params: params});
  }


  // Download a file
  downloadFile(fileID: number):Observable<Blob>{
    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type':  'image/jpeg',
    //     'Transfer-Encoding':'chunked',
    //   })
    // };
    return this.http.get(this.BASE_URL + '/downloadFile/' + fileID,{responseType: 'blob'})
  }

  removeFile(fileID: number) {
    return this.http.get(this.BASE_URL + '/166' )
  }
}
