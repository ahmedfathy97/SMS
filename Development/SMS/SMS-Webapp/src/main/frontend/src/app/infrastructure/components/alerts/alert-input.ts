export class AlertInput {
  static SUCCESS_STATUS: string = 's';
  static FAILURE_STATUS: string = 'f';

  status: string;
  message: string;
  appear: boolean = false;
  data = [];

  constructor(status?: string, message?:string){
    this.status = status;
    this.message = message;

    if(this.status != null && this.message != null) {
      this.appear = true;
      setTimeout(() => this.appear = false, 10000);
    }
  }
}
