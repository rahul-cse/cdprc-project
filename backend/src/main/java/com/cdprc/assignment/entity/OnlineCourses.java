package com.cdprc.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OnlineCourses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String courseName;
    private String courseSite;
    private Double amount;  // in taka
    @JsonBackReference
    @JoinColumn(name="claim_request_id")
    @ManyToOne()
    private ClaimRequest claimRequest;
}
