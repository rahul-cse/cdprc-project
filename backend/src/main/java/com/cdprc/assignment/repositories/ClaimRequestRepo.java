package com.cdprc.assignment.repositories;

import com.cdprc.assignment.entity.ClaimRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRequestRepo extends JpaRepository<ClaimRequest,Long> {
}
