import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClaimApprovalService {

  constructor(private _http: HttpClient) { }
  
  claimApproveUrl:string = environment.backendApiUrl + "claim-approve/";

  saveApproval(claimApproval):Observable<any>{
    return this._http.post(this.claimApproveUrl,claimApproval);
  }
}
