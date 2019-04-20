import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule, HttpHeaders, HttpParams} from "@angular/common/http";
import {FileVTO} from "./data/FileVTO"

@Injectable({
  providedIn: 'root'
})
export class AttachmentService {

  file: FileVTO;

  constructor(private http: HttpClient) {
  }

  // Upload files to server
  uploadFiles(fd: FormData, name, type, size, ext) {
    // let headers = new HttpHeaders();
    // headers.set('Content-Type', null);
    // headers.set('Accept', "multipart/form-data");;

    const params = new HttpParams()
      .set("name", name)
      .set("type", type)
      .set("size", size)
      .set("ext", ext);

    this.http.post("http://localhost:8080/api/attachment/file", fd, {params: params})
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
  viewFiles(sourceID) {
    return this.http.get<FileVTO[]>('http://localhost:8080/api/attachment/files/'+ sourceID);
  }


  // Download a file
  downloadFile(fileID: number) {
    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type':  'image/jpeg',
    //     'Transfer-Encoding':'chunked',
    //   })
    // };
    return this.http.get('http://localhost:8080/api/attachment/downloadFile/' + fileID,{responseType: 'blob'})
  }

  removeFile(fileID: number) {
    return this.http.get('http://localhost:8080/api/attachment/166' )
  }
}
