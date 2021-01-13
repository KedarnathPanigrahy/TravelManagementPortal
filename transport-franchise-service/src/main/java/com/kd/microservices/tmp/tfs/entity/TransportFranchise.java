package com.kd.microservices.tmp.tfs.entity;

import com.kd.microservices.tmp.tfs.enums.TransportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransportFranchise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long franchiseId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    private TransportType type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<>();
}
