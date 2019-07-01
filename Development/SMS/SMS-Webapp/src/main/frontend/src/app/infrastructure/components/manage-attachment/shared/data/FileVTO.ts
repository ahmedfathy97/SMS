export class FileVTO {
  constructor(id: number, name: string, contentType: string, extension: string, size: number, uploadDate: string, startDate: string, endDate: string, corID: number, sourceID: number, fileSourceID: number) {
    this._id = id;
    this._name = name;
    this._contentType = contentType;
    this._extension = extension;
    this._size = size;
    this._uploadDate = uploadDate;
    this._startDate = startDate;
    this._endDate = endDate;
    this._corID = corID;
    this._sourceID = sourceID;
    this._fileSourceID = fileSourceID;
  }

  private _id: number;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  private _name: string;

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  private _contentType?: string;

  get contentType(): string {
    return this._contentType;
  }

  set contentType(value: string) {
    this._contentType = value;
  }

  private _extension?: string;

  get extension(): string {
    return this._extension;
  }

  set extension(value: string) {
    this._extension = value;
  }

  private _size?: number;

  get size(): number {
    return this._size;
  }

  set size(value: number) {
    this._size = value;
  }

  private _uploadDate: string;

  get uploadDate(): string {
    return this._uploadDate;
  }

  set uploadDate(value: string) {
    this._uploadDate = value;
  }

  private _content: File;

  get content(): File {
    return this._content;
  }

  set content(value: File) {
    this._content = value;
  }

  private _startDate?: string;

  get startDate(): string {
    return this._startDate;
  }

  set startDate(value: string) {
    this._startDate = value;
  }

  private _endDate?: string;

  get endDate(): string {
    return this._endDate;
  }

  set endDate(value: string) {
    this._endDate = value;
  }

  private _corID?: number;

  get corID(): number {
    return this._corID;
  }

  set corID(value: number) {
    this._corID = value;
  }

  private _sourceID: number;

  get sourceID(): number {
    return this._sourceID;
  }

  set sourceID(value: number) {
    this._sourceID = value;
  }

  private _fileSourceID: number;

  get fileSourceID(): number {
    return this._fileSourceID;
  }

  set fileSourceID(value: number) {
    this._fileSourceID = value;
  }
}
