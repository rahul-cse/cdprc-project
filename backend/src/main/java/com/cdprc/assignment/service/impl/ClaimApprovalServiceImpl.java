package com.cdprc.assignment.service.impl;

import com.cdprc.assignment.entity.ClaimApproval;
import com.cdprc.assignment.repositories.ClaimApprovalRepo;
import com.cdprc.assignment.service.ClaimApprovalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClaimApprovalServiceImpl implements ClaimApprovalService {
    ClaimApprovalRepo claimApprovalRepo;
    @Override
    public ClaimApproval saveClaimApproval(ClaimApproval claimApproval) {
        return claimApprovalRepo.save(claimApproval);
    }
}
