package com.kd.microservices.tmp.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.microservices.tmp.tms.constant.Constants;
import com.kd.microservices.tmp.tms.dto.CustomerDto;
import com.kd.microservices.tmp.tms.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
    
    @PostMapping("/save")
    @CrossOrigin
    @ApiOperation(value = "Saving a customer Information", notes = "This Endpoint is used to save customer information", nickname = "customerInfo")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Registered"), @ApiResponse(code = 200, message = "Customer Registered")})
    ResponseEntity<String> saveCustomer(@RequestBody CustomerDto dto) {
        return new ResponseEntity<>(customerService.saveCustomer(dto), HttpStatus.OK);
    }

    @PostMapping("/saveCustomers")
    @CrossOrigin
    @ApiOperation(value = "Saving Multiple customers Information", notes = "This Endpoint is used to save multiple customers information", nickname = "customersInfo")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Registered"), @ApiResponse(code = 200, message = "Customer Registered")})
    void saveCustomerList(@RequestBody List<CustomerDto> customers) {
        customerService.saveCustomerList(customers);
    }
    
    @GetMapping("/getUsers")
    @CrossOrigin
    @ApiOperation(value = "Getting customers Information", notes = "This Endpoint is used to Get all customers information", nickname = "customersInfo")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer List"), @ApiResponse(code = 200, message = "Customer List")})
    ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
}
