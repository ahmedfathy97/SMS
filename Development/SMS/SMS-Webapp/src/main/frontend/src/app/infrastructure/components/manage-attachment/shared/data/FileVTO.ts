export class FileVTO {
  id: number;
  name: string;
  contentType: string;
  size: number;
  uploadDate: Date;
  // dueDate?: Date;
  content: File;
  extension: string;
  sourceID: number;

  // fileSourceID:number;

  constructor(id: number, name: string, type: string, extension: string, size: number, uploadDate: Date,sourceID: number, dueDate?: Date ,// ,fileSourceID:number
  ) {
    this.id = id;
    this.name = name;
    this.contentType = type;
    this.extension = extension;
    this.size = size;
    // this.content = content;
    this.uploadDate = uploadDate;
    // this.dueDate = dueDate;
    this.sourceID = sourceID;
    // this.fileSourceID = fileSourceID;
  }

}
