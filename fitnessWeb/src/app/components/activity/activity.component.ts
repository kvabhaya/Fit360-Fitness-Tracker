import { Component } from '@angular/core';
import {NzCardComponent, NzCardGridDirective} from "ng-zorro-antd/card";
import {DatePipe, NgForOf, NgStyle} from "@angular/common";
import {NzColDirective} from "ng-zorro-antd/grid";
import {NzFormControlComponent, NzFormDirective, NzFormItemComponent} from "ng-zorro-antd/form";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {NzInputDirective} from "ng-zorro-antd/input";
import {NzDatePickerComponent} from "ng-zorro-antd/date-picker";
import {NzButtonComponent} from "ng-zorro-antd/button";
import {NzMessageService} from "ng-zorro-antd/message";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-activity',
  standalone: true,
  imports: [
    NzCardGridDirective,
    NgStyle,
    NzColDirective,
    NzCardComponent,
    NzFormDirective,
    ReactiveFormsModule,
    NzFormItemComponent,
    NzFormControlComponent,
    NzInputDirective,
    NzDatePickerComponent,
    NzButtonComponent,
    DatePipe,
    NgForOf
  ],
  templateUrl: './activity.component.html',
  styleUrl: './activity.component.scss'
})
export class ActivityComponent {
  gridStyle = {
    width:'100%',
    textAlign: 'center'
  };
  activityForm!: FormGroup;
  activities: any;
  constructor(private fb:FormBuilder,
              private message: NzMessageService,
              private userService: UserService
  ) {}
  ngOnInit(){
    this.activityForm = this.fb.group({
      caloriesBurned:[null, [Validators.required]],
      steps:[null, [Validators.required]],
      distance:[null, [Validators.required]],
      date:[null, [Validators.required]],
    })
    this.getAllActivities();
  }

  submitForm(){
    this.userService.postActivity(this.activityForm.value).subscribe(res=>{
      this.message.success("Activity posted successfully", {nzDuration: 5000});
      this.activityForm.reset();
      this.getAllActivities();

    },error => {
      this.message.error("Error while posting activity", {nzDuration: 5000});
    })
  }
  getAllActivities(){
    this.userService.getActivities().subscribe(res=>{
      this.activities = res;
      console.log(this.activities);
    })
  }
}
