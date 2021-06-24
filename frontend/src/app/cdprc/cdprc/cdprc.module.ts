import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CdprcRoutingModule } from './cdprc-routing.module';
import { ClaimRequestComponent } from './claim-request/claim-request.component';
import { FormsModule } from '@angular/forms';
import { ClaimRequestListComponent } from './claim-request-list/claim-request-list.component';
import { ApproveClaimComponent } from './approve-claim/approve-claim.component';



@NgModule({
  declarations: [
    ClaimRequestComponent,
    ClaimRequestListComponent,
    ApproveClaimComponent,
   
  ],
  imports: [
    CommonModule,
    FormsModule,   
    CdprcRoutingModule
  ]
})
export class CdprcModule { }
