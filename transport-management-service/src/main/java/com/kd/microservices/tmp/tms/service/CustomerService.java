package com.kd.microservices.tmp.tms.service;

import com.kd.microservices.tmp.tms.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    public String userLogin(CustomerDto dto) {
        final String URL = "http://CUSTOMER-SERVICE/customers/login";
        return restTemplate.postForEntity(URL, dto, String.class).getBody();
    }

}
