package com.cdprc.assignment.repositories;

import com.cdprc.assignment.entity.ClaimApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimApprovalRepo extends JpaRepository<ClaimApproval, Long> {
}
