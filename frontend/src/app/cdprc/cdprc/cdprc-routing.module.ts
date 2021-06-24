import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApproveClaimComponent } from './approve-claim/approve-claim.component';
import { ClaimRequestListComponent } from './claim-request-list/claim-request-list.component';
import { ClaimRequestComponent } from './claim-request/claim-request.component';


const routes: Routes = [
  {
    path: '',
    data: {
      title: 'CDPRC'
    },
    children:[
      {path:'claim-request', component:ClaimRequestComponent},
      {path:'claim-request-list', component:ClaimRequestListComponent},
      {path:'approve-claim/:id', component:ApproveClaimComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CdprcRoutingModule {}
