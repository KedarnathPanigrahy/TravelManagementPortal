package com.kd.microservices.tmp.ns.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	private Long custId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emailId;
	private String mobileNumber;
	private String address;
	private String pinCode;
	private Date createdDate;
	private Date updatedDate;
}
