package com.cdprc.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ClaimRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String employeeName;
    private String employeeId;
    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;
    @JoinColumn(name="claim_request_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineCourses> OnlineCourses = new ArrayList<OnlineCourses>();
}
