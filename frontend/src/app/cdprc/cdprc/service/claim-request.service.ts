import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'; 
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClaimRequestService {

  constructor(private _http:HttpClient) { }

  claimRequestUrl:string = environment.backendApiUrl + "claim-request/";
  claimRequestsUrl:string = environment.backendApiUrl + "claim-requests/";

  createClaimRequest(claimRequest):Observable<any>{
    return this._http.post(this.claimRequestUrl,claimRequest).pipe(
      catchError(this.handleError));
  }

  getAllClaimRequest():Observable<any>{
    return this._http.get(this.claimRequestsUrl);
  }

  getClaimRequest(id):Observable<any> {
    return this._http.get(this.claimRequestUrl+id);
  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
        // client-side error
        errorMessage = `Error: ${error.error.message}`;
    } else {
        // server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }

}
