package com.kd.microservices.tmp.tms.controller;

import com.kd.microservices.tmp.tms.constant.Constants;
import com.kd.microservices.tmp.tms.dto.CustomerDto;
import com.kd.microservices.tmp.tms.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transport/customers")
@Api(tags = "Provides Endpoint to get Transport Details")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/login")
    @CrossOrigin
    @ApiOperation(value = "User Login", notes = "This Endpoint is used to Authenticate User", nickname = "userLogin")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "User Login Success"), @ApiResponse(code = 200, message = "User Login Success")})
    ResponseEntity<String> userLogin(@RequestBody CustomerDto dto) {
        if (!dto.getUserName().isEmpty() && !dto.getPassword().isEmpty())
            return new ResponseEntity<>(customerService.userLogin(dto), HttpStatus.OK);
        else
            return new ResponseEntity<>(Constants.INVALID_USER, HttpStatus.BAD_REQUEST);
    }
}
