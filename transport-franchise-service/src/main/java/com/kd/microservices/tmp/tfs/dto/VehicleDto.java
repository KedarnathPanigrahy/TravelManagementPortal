package com.kd.microservices.tmp.tfs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private String number;
    private String engineNumber;
    private Date expiryDate = new Date();
    private String source;
    private String destination;
    private String franchiseName;
    private String franchiseCode;

}
