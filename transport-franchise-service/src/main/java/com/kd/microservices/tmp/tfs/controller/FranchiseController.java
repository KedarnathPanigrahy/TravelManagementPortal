package com.kd.microservices.tmp.tfs.controller;

import com.kd.microservices.tmp.tfs.dto.TransportDto;
import com.kd.microservices.tmp.tfs.entity.Vehicle;
import com.kd.microservices.tmp.tfs.service.FranchiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
@Api(tags = "Provides Endpoint to get Transport Franchise Details")
public class FranchiseController {
    @Autowired
    FranchiseService service;

    @GetMapping("/find-all")
    @CrossOrigin
    @ApiOperation(value = "Find Transport Franchises", notes = "This Endpoint is used to Find Transport Franchises", nickname = "findAllFranchises")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Find Franchises Success"), @ApiResponse(code = 200, message = "Find Franchises Success")})
    public ResponseEntity<List<TransportDto>> findAllFranchises() {
        return new ResponseEntity<>(service.getAllTransports(), HttpStatus.OK);
    }

    @GetMapping("/find-by-type/{type}")
    @CrossOrigin
    @ApiOperation(value = "Find a Transport Franchise by Franchise Type", notes = "This Endpoint is used to Find a Transport Franchise by Franchise Type", nickname = "findFranchisesByType")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Franchises by Franchise Type Success"), @ApiResponse(code = 200, message = "Franchises by Franchise Type Success")})
    public ResponseEntity<List<TransportDto>> findFranchisesByType(@PathVariable("type") String type) {
        return new ResponseEntity<>(service.getFranchisesByType(type), HttpStatus.OK);
    }

    @GetMapping("/find-by-name/{name}")
    @CrossOrigin
    @ApiOperation(value = "Find a Transport Franchise by Franchise Name", notes = "This Endpoint is used to Find a Transport Franchise by Franchise Name", nickname = "findFranchiseByName")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Franchise by Franchise Name Success"), @ApiResponse(code = 200, message = "Franchise by Franchise Name Success")})
    public ResponseEntity<TransportDto> findFranchiseByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(service.getTransportFranchiseByName(name), HttpStatus.OK);
    }

    @GetMapping("/find-by-id/{id}")
    @CrossOrigin
    @ApiOperation(value = "Find a Transport Franchise by Franchise Id", notes = "This Endpoint is used to Find a Transport Franchise by Franchise Id", nickname = "findFranchiseById")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Franchise by Franchise Id Success"), @ApiResponse(code = 200, message = "Franchise by Franchise Id Success")})
    public ResponseEntity<TransportDto> findFranchiseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getTransportFranchiseByFranchiseId(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @CrossOrigin
    @ApiOperation(value = "Registering a Transport Franchise", notes = "This Endpoint is used to Registering a Transport Franchise", nickname = "registerTransportFranchise")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Franchise Registered"), @ApiResponse(code = 200, message = "Franchise Registered")})
    public ResponseEntity<TransportDto> saveFranchise(@RequestBody TransportDto dto) {
        return new ResponseEntity<>(service.saveFranchise(dto), HttpStatus.OK);
    }

    @PostMapping("/save-all")
    @CrossOrigin
    @ApiOperation(value = "Registering Transport Franchises", notes = "This Endpoint is used to Registering Transport Franchises", nickname = "registerTransportFranchises")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Franchises Registered"), @ApiResponse(code = 200, message = "Franchises Registered")})
    public ResponseEntity<List<TransportDto>> saveFranchiseList(@RequestBody List<TransportDto> dtoList) {
        return new ResponseEntity<>(service.saveFranchiseList(dtoList), HttpStatus.OK);
    }

    @GetMapping("/find-by-source-destination")
    public ResponseEntity<List<Vehicle>> getVehicleBySourceAndDestination() {
        List<Vehicle> vehicles = service.getVehicleBySourceAndDestination();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    /*@GetMapping("/find-by-type-source-destination")
    public ResponseEntity<List<Vehicle>> getVehicleByTypeSourceAndDestination() {
        List<Vehicle> vehicles = service.getVehicleByTypeSourceAndDestination();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }*/


}
