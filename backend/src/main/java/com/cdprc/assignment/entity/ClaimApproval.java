package com.cdprc.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class ClaimApproval {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @OneToOne
    private ClaimRequest claimRequest;
    private Double totalClaimAmount;
    private LocalDateTime approvalDateTime;

    @PrePersist
    public void onCreate(){
        this.approvalDateTime = LocalDateTime.now();
    }
}
