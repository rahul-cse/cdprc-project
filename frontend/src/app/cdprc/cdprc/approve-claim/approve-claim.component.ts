import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ClaimApproval } from '../models/claim-approval.model';
import { ClaimRequest } from '../models/claim-request.model';
import { OnlineCourses } from '../models/online-courses.model';
import { ClaimApprovalService } from '../service/claim-approval.service';
import { ClaimRequestService } from '../service/claim-request.service';

@Component({
  selector: 'app-approve-claim',
  templateUrl: './approve-claim.component.html',
  styleUrls: ['./approve-claim.component.scss']
})
export class ApproveClaimComponent implements OnInit {

  constructor(private claimRequestService:ClaimRequestService,private claimApprovalService : ClaimApprovalService,private route: ActivatedRoute, private toastr: ToastrService) { }

  claimRequest: ClaimRequest;
  totalAmount:number=0;
  flag:boolean=false;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.claimRequestService.getClaimRequest(id).subscribe(res=>{
      this.claimRequest = res;
      this.calculateTotal();
      this.flag=true;
    })
  }
  calculateTotal(){
    this.claimRequest.onlineCourses.forEach(onlineCourse=>{
      this.totalAmount = this.totalAmount + onlineCourse.amount; 
    })
  }

  approve(){
    console.log(this.claimRequest);
    let claimApproval = new ClaimApproval();
    claimApproval.claimRequest=this.claimRequest;
    claimApproval.totalClaimAmount=this.totalAmount;
    this.claimApprovalService.saveApproval(claimApproval).subscribe(res=>{
      if(res=='CREATED'){
        this.toastr.success("Employee Id-" + this.claimRequest.employeeId + " claim is approved.")
      }
    })
  }

}
