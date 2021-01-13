package com.kd.microservices.tmp.tfs.repository;

import com.kd.microservices.tmp.tfs.entity.Vehicle;
import com.kd.microservices.tmp.tfs.enums.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> getVehicleBySourceAndDestination(String source, String destination);

    //List<Vehicle> getVehicleByTypeAndSourceAndDestination(TransportType type, String source, String destination);
}
