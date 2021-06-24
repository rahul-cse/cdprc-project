package com.cdprc.assignment.service;

import com.cdprc.assignment.entity.ClaimRequest;

import java.util.List;

public interface ClaimRequestService {
    public ClaimRequest createClaimRequest(ClaimRequest claimRequest);

    List<ClaimRequest> getAllClaimRequest();

    ClaimRequest getClaimRequest(Long id);

    ClaimRequest updateClaimRequest(ClaimRequest claimRequest);
}
