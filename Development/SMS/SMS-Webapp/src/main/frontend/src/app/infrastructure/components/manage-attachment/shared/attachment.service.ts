import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule, HttpHeaders, HttpParams} from "@angular/common/http";
import {FileDTO} from "./data/FileDTO";

@Injectable({
  providedIn: 'root'
})
export class AttachmentService {

  file: FileDTO;

  constructor(private http: HttpClient) {
  }

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

  viewFiles() {
    this.http.get<FileDTO>("http://localhost:8080/api/attachment/files");
  }

  downloadFile(id: number) {
  }

  removeFile(id: number) {
  }
}
