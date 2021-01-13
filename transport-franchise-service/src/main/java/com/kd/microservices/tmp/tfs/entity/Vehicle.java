package com.kd.microservices.tmp.tfs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    private String franchiseName;
    @Column(nullable = false)
    private String franchiseCode;
    @Column(nullable = false, unique = true)
    private String number;
    @Column(nullable = false, unique = true)
    private String engineNumber;
    private Date engExpiryDate = new Date();
    @Column(nullable = false)
    private String source;
    @Column(nullable = false)
    private String destination;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchiseId", nullable = false)
    private TransportFranchise transportFranchise;

    public TransportFranchise getTransportFranchise() {
        return transportFranchise;
    }

    public void setTransportFranchise(TransportFranchise transportFranchise) {
        this.transportFranchise = transportFranchise;
    }*/
}
