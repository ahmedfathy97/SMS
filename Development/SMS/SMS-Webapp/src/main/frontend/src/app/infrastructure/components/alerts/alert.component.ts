import {Component, Input, OnChanges, OnInit, SimpleChanges} from "@angular/core";
import {AlertInput} from "./alert-input";

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html'
})
export class AlertComponent implements OnInit, OnChanges {
  @Input() data: AlertInput;

  constructor(){
  }

  ngOnInit(){
  }

  ngOnChanges(changes: SimpleChanges){
    if(changes.alertInput != null){
      this.data = changes.alertInput.currentValue;
    }
  }

  onCloseAlert(){
    this.data.appear = false;
  }
}
