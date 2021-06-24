import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ClaimRequest } from '../models/claim-request.model';
import { OnlineCourses } from '../models/online-courses.model';
import { ClaimRequestService } from '../service/claim-request.service';


@Component({
  selector: 'app-claim-request',
  templateUrl: './claim-request.component.html',
  styleUrls: ['./claim-request.component.scss']
})
export class ClaimRequestComponent implements OnInit {

  constructor(private claimRequestService:ClaimRequestService, private toastr: ToastrService) { }

  claimRequest:ClaimRequest = new ClaimRequest();
  onlineCourses:OnlineCourses[]=[];

  successFlag:boolean=false;

  ngOnInit(): void {
    this.claimRequest.onlineCourses=this.onlineCourses;
  }


  addCourse(){
    console.log(this.onlineCourses)
    let onlineCourse = new OnlineCourses();
    this.onlineCourses.push(onlineCourse);
  }

  deleteCourse(index){
    this.onlineCourses.splice(index,1)
  }


  onSubmit(form:NgForm){
    console.log(this.claimRequest)
    const newClaimRequest:ClaimRequest = (form.value);
    this.claimRequestService.createClaimRequest(this.claimRequest).subscribe(data=>{if(data=='CREATED') {this.claimRequest=new ClaimRequest(),this.onlineCourses=[],this.claimRequest.onlineCourses=this.onlineCourses;
      this.toastr.success("Your requisition is submitted.")
    }});
  }
}
