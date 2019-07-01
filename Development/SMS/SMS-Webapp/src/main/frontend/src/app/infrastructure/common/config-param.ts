import {FormGroup} from "@angular/forms";


export class ConfigParam{
  static APP_BASE_URL: string = "http://localhost:8080/api";
  static PAGE_SIZE: number = 5;

  static markControlsDirty(group: FormGroup): void {
    Object.keys(group.controls).forEach((key: string) => {
      const abstractControl = group.controls[key];

      if (abstractControl instanceof FormGroup) {
        this.markControlsDirty(abstractControl);
      } else {
        abstractControl.markAsTouched();
        abstractControl.markAsDirty();
      }
    });
  }
}
