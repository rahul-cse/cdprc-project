package com.cdprc.assignment.controller;

import com.cdprc.assignment.entity.ClaimRequest;
import com.cdprc.assignment.service.ClaimRequestService;
import com.cdprc.assignment.url_constant.ClaimRequestUrlConstant;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class ClaimRequestController {

    ClaimRequestService claimRequestService;

    @GetMapping(ClaimRequestUrlConstant.claimRequest+ClaimRequestUrlConstant.id)
    public ResponseEntity getClaimRequest(@PathVariable("id") String strId) {
        Long id = null;
        try{
           id = Long.parseLong(strId);
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().body("Invalid Id");
        }

        ClaimRequest claimRequest = claimRequestService.getClaimRequest(id);
        return ResponseEntity.ok(claimRequest);

    }

    @PostMapping(ClaimRequestUrlConstant.claimRequest)
    public ResponseEntity createClaimRequest(@RequestBody ClaimRequest claimRequest){
        claimRequestService.createClaimRequest(claimRequest);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping(ClaimRequestUrlConstant.claimRequests)
    public ResponseEntity<List<ClaimRequest>> getAllClaimRequests(){
        List<ClaimRequest> claimRequestList = claimRequestService.getAllClaimRequest();
        return ResponseEntity.ok(claimRequestList);
    }


}
