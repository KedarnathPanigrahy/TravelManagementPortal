package com.kd.microservices.tmp.tfs.repository;

import com.kd.microservices.tmp.tfs.entity.TransportFranchise;
import com.kd.microservices.tmp.tfs.enums.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FranchiseRepository extends JpaRepository<TransportFranchise, Long> {
    TransportFranchise getTransportFranchiseByFranchiseId(Long franchiseId);

    TransportFranchise getTransportFranchiseByName(String name);

    List<TransportFranchise> getAllByType(TransportType type);

    TransportFranchise getTransportFranchiseByNameAndCodeAndType(String name, String code, TransportType type);
}
