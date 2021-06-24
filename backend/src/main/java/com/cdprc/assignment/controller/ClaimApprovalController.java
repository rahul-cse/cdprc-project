package com.cdprc.assignment.controller;

import com.cdprc.assignment.entity.ClaimApproval;
import com.cdprc.assignment.service.ClaimApprovalService;
import com.cdprc.assignment.service.ClaimRequestService;
import com.cdprc.assignment.url_constant.ClaimApprovalUrlConstant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ClaimApprovalController {

    ClaimApprovalService claimApprovalService;
    ClaimRequestService claimRequestService;

    @PostMapping(ClaimApprovalUrlConstant.claimApproval)
    public ResponseEntity saveClaimApproval(@RequestBody ClaimApproval claimApproval){
        ClaimApproval  newClaimApproval =   claimApprovalService.saveClaimApproval(claimApproval);
        if(newClaimApproval!=null){
            newClaimApproval.getClaimRequest().setIsApproved(true);
            claimRequestService.updateClaimRequest(newClaimApproval.getClaimRequest());
        }
      return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
