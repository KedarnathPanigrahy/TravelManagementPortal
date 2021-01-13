package com.kd.microservices.tmp.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private String userName;
    private String emailId;
    private String mobileNumber;

    private String franchiseName;
    private String franchiseCode;
    private String vehicleNumber;
    private int rowNumber;
    private int seatNumber;
}
