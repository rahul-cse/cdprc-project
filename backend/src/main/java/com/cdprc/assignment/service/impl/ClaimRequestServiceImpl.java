package com.cdprc.assignment.service.impl;

import com.cdprc.assignment.entity.ClaimRequest;
import com.cdprc.assignment.entity.OnlineCourses;
import com.cdprc.assignment.repositories.ClaimRequestRepo;
import com.cdprc.assignment.repositories.OnlineCoursesRepo;
import com.cdprc.assignment.service.ClaimRequestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClaimRequestServiceImpl implements ClaimRequestService {
    ClaimRequestRepo claimRequestRepo;
    OnlineCoursesRepo onlineCoursesRepo;
    @Override
    public ClaimRequest createClaimRequest(ClaimRequest claimRequest) {
        ClaimRequest newClaimRequest = claimRequestRepo.save(claimRequest);
        return newClaimRequest;
    }

    @Override
    public List<ClaimRequest> getAllClaimRequest() {
        return claimRequestRepo.findAll();
    }

    @Override
    public ClaimRequest getClaimRequest(Long id) {
        Optional<ClaimRequest> claimRequestOpt = claimRequestRepo.findById(id);
        if(claimRequestOpt.isPresent())
            return claimRequestOpt.get();
        else
            return null;
    }

    @Override
    public ClaimRequest updateClaimRequest(ClaimRequest claimRequest) {
        List<OnlineCourses> onlineCoursesList = onlineCoursesRepo.findAllByClaimRequest(claimRequest);
        ClaimRequest newClaimRequest = new ClaimRequest();
        BeanUtils.copyProperties(claimRequest, newClaimRequest);
        newClaimRequest.setOnlineCourses(onlineCoursesList);
        return claimRequestRepo.save(newClaimRequest);
    }
}
