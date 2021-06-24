import { ClaimRequest } from "./claim-request.model";

export class ClaimApproval{
    id:number;
    totalClaimAmount:number
    claimRequest:ClaimRequest;
}