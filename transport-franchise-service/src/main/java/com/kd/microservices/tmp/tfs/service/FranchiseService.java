package com.kd.microservices.tmp.tfs.service;

import com.kd.microservices.tmp.tfs.dto.TransportDto;
import com.kd.microservices.tmp.tfs.dto.VehicleDto;
import com.kd.microservices.tmp.tfs.entity.TransportFranchise;
import com.kd.microservices.tmp.tfs.entity.Vehicle;
import com.kd.microservices.tmp.tfs.enums.TransportType;
import com.kd.microservices.tmp.tfs.repository.FranchiseRepository;
import com.kd.microservices.tmp.tfs.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FranchiseService {

    @Autowired
    FranchiseRepository repository;
    @Autowired
    VehicleRepository vehicleRepository;

    public TransportDto saveFranchise(TransportDto dto) {
        List<TransportDto> dtos = new ArrayList<>(1);
        dtos.add(dto);
        return saveEntities(dtos).get(0);
    }

    public List<TransportDto> saveFranchiseList(List<TransportDto> dtoList) {
        return saveEntities(dtoList);
    }

    public TransportDto getTransportFranchiseByFranchiseId(Long franchiseId) {
        List<TransportFranchise> franchises = new ArrayList<>();
        franchises.add(repository.getTransportFranchiseByFranchiseId(franchiseId));

        return convertEntotiesIntoDtos(franchises).get(0);
    }

    public TransportDto getTransportFranchiseByName(String name) {
        List<TransportFranchise> franchises = new ArrayList<>();
        franchises.add(repository.getTransportFranchiseByName(name));

        return convertEntotiesIntoDtos(franchises).get(0);
    }

    public List<TransportDto> getFranchisesByType(String type) {
        return convertEntotiesIntoDtos(repository.getAllByType(TransportType.of(type)));
    }

    public List<TransportDto> getAllTransports() {
        return convertEntotiesIntoDtos(repository.findAll());
    }

    public List<Vehicle> getVehicleBySourceAndDestination() {
        return vehicleRepository.getVehicleBySourceAndDestination("BNG", "BBS");
    }

    /*public List<Vehicle> getVehicleByTypeSourceAndDestination() {
        return vehicleRepository.getVehicleByTypeAndSourceAndDestination(TransportType.of("flight"), "BNG", "BBS");
    }*/

    private List<TransportDto> saveEntities(List<TransportDto> dtoList) {
        boolean done;
        final List<TransportFranchise> FRANCHISE_LIST = new ArrayList<>(dtoList.size());
        do {
            if (!dtoList.isEmpty()) {
                dtoList.forEach(dto -> {
                    try {
                        TransportFranchise franchise = new TransportFranchise();
                        final List<Vehicle> VEHICLES = new ArrayList<>(dto.getVehicles().size());

                        dto.getVehicles().forEach(vehicleDto -> {
                            Vehicle vehicle = new Vehicle();
                            vehicle.setEngineNumber(vehicleDto.getEngineNumber());
                            vehicle.getEngExpiryDate();
                            vehicle.setNumber(vehicleDto.getNumber());
                            vehicle.setSource(vehicleDto.getSource());
                            vehicle.setDestination(vehicleDto.getDestination());
                            vehicle.setFranchiseName(dto.getName());
                            vehicle.setFranchiseCode(dto.getCode());
                            VEHICLES.add(vehicle);
                            vehicleRepository.save(vehicle);
                        });

                        franchise.setCode(dto.getCode());
                        franchise.setName(dto.getName());
                        franchise.setType(TransportType.of(dto.getType()));
                        franchise.setVehicles(VEHICLES);
                        repository.save(franchise);

                        FRANCHISE_LIST.add(franchise);
                    } catch (Exception e) {
                    }
                });
            }
            done = true;
            return convertEntotiesIntoDtos(new ArrayList<>(FRANCHISE_LIST));
        } while (!done);
    }

    private List<TransportDto> convertEntotiesIntoDtos(List<TransportFranchise> franchiseList) {
        final List<TransportDto> DTOS = new ArrayList<>(franchiseList.size());
        if (!franchiseList.isEmpty()) {
            franchiseList.forEach(franchise -> {
                TransportDto dto = new TransportDto();
                List<VehicleDto> vDTOList = new ArrayList<>(franchise.getVehicles().size());
                dto.setCode(franchise.getCode());
                dto.setName(franchise.getName());
                dto.setType(franchise.getType().getValue());
                franchise.getVehicles().forEach(vehicle -> {
                    VehicleDto vDTO = new VehicleDto();
                    vDTO.setEngineNumber(vehicle.getEngineNumber());
                    vDTO.setExpiryDate(vehicle.getEngExpiryDate());
                    vDTO.setNumber(vehicle.getNumber());
                    vDTO.setSource(vehicle.getSource());
                    vDTO.setDestination(vehicle.getDestination());
                    vDTO.setFranchiseName(franchise.getName());
                    vDTO.setFranchiseCode(franchise.getCode());
                    vDTOList.add(vDTO);
                });
                dto.setVehicles(vDTOList);

                DTOS.add(dto);
            });
        }
        return DTOS;
    }
}
