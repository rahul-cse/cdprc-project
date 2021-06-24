import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClaimRequest } from '../models/claim-request.model';
import { ClaimRequestService } from '../service/claim-request.service';

@Component({
  selector: 'app-claim-request-list',
  templateUrl: './claim-request-list.component.html',
  styleUrls: ['./claim-request-list.component.scss']
})
export class ClaimRequestListComponent implements OnInit {

  constructor(private claimRequestService:ClaimRequestService,private router:Router) { }

  claimRequestList:ClaimRequest[]=[];

  ngOnInit(): void {
    this.claimRequestService.getAllClaimRequest().subscribe(res=>{
      this.claimRequestList = res;
    })
  }

  viewApproval(id){
    this.router.navigate(['cpdrc/approve-claim',id])
  }

}
