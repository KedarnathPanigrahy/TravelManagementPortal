package com.kd.microservices.tmp.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kd.microservices.tmp.tms.constant.Constants;
import com.kd.microservices.tmp.tms.dto.CustomerDto;

@Service
public class CustomerService {

	@Autowired
    RestTemplate restTemplate;
    
    private final String URL = "http://CUSTOMER-SERVICE/customers/";
    
    public String saveCustomer(CustomerDto customer) {
		return restTemplate.postForEntity(URL+"save", customer, String.class).getBody();
	}

	public String saveCustomerList(List<CustomerDto> customers) {
		return restTemplate.postForEntity(URL+"saveCustomers", customers, String.class).getBody();
	}

    public String userLogin(CustomerDto customer) {
    	String status = restTemplate.postForEntity(URL+"login", customer, String.class).getBody();
    	
    	if(status.equals(Constants.SUCCESS)) {
    		return restTemplate.getForEntity(URL+"getByUserName/"+customer.getUserName(), String.class).getBody();
    	} else {
    		return status;
    	}
    }

	public List<CustomerDto> getAllCustomers() {
		return restTemplate.getForEntity(URL+"getUsers", List.class).getBody();
	}

}
