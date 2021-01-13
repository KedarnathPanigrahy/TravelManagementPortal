package com.kd.microservices.tmp.tfs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportDto {
    private String name;
    private String code;
    private String type;
    private List<VehicleDto> vehicles;
}
