package com.cdprc.assignment.repositories;

import com.cdprc.assignment.entity.ClaimRequest;
import com.cdprc.assignment.entity.OnlineCourses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OnlineCoursesRepo extends JpaRepository<OnlineCourses, Long> {
    List<OnlineCourses> findAllByClaimRequest(ClaimRequest claimRequest);
}
