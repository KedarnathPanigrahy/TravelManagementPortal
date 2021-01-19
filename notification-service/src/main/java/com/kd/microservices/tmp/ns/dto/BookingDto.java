package com.kd.microservices.tmp.ns.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
	private String customerName;
    private String emailId;
    private String mobileNumber;

    private String vendorName;
    private String vendorCode;
    private String vehicleName;
    private String vehicleNumber;
    private String rowNumber;
    private String seatNumber;
}
