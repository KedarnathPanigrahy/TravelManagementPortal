package com.kd.microservices.tmp.cms.controller;

import com.kd.microservices.tmp.cms.dto.CustomerDto;
import com.kd.microservices.tmp.cms.model.Customer;
import com.kd.microservices.tmp.cms.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Api(tags = "Provides Endpoint to get Customer Details")
public class CustomerController {

    @Autowired
    private Environment environment;

    @Autowired
    private CustomerService customerService;

    @CrossOrigin
    @ApiOperation(value = "Check status of Customer service", notes = "This Endpoint is used to check the status of Customer Service service", nickname = "/status/check")
    @GetMapping("/status/check")
    public String status() {
        return "The service is up and running in environment - " + environment.getProperty("spring.application.name");
    }

    @PostMapping("/save")
    @CrossOrigin
    @ApiOperation(value = "Saving a customer Information", notes = "This Endpoint is used to save customer information", nickname = "customerInfo")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Registered"), @ApiResponse(code = 200, message = "Customer Registered")})
    ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto dto) {
        return new ResponseEntity<>(customerService.saveCustomer(dto), HttpStatus.OK);
    }

    @PostMapping("/saveCustomers")
    @CrossOrigin
    @ApiOperation(value = "Saving Multiple customers Information", notes = "This Endpoint is used to save multiple customers information", nickname = "customersInfo")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Registered"), @ApiResponse(code = 200, message = "Customer Registered")})
    void saveCustomerList(@RequestBody List<Customer> customers) {
        customerService.saveCustomerList(customers);
    }

    @GetMapping("/getById/{id}")
    @CrossOrigin
    @ApiOperation(value = "Getting customer Information", notes = "This Endpoint is used to Get customer information By Customer Id", nickname = "customersInfoById")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Registered"), @ApiResponse(code = 200, message = "Customer Registered")})
    ResponseEntity<CustomerDto> getCustomerByCustId(@PathVariable("id") Long custId) {
        return new ResponseEntity<>(customerService.getCustomerByCustId(custId), HttpStatus.OK);
    }

    @GetMapping("/getByUserName/{name}")
    @CrossOrigin
    @ApiOperation(value = "Getting customer Information", notes = "This Endpoint is used to Get customer information By Customer username", nickname = "customersInfoByName")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Registered"), @ApiResponse(code = 200, message = "Customer Registered")})
    ResponseEntity<CustomerDto> getCustomerByUserName(@PathVariable("name") String userName) {
        return new ResponseEntity<>(customerService.getCustomerByUserName(userName), HttpStatus.OK);
    }

    @PostMapping("/login")
    @CrossOrigin
    @ApiOperation(value = "Customer Login", notes = "This Endpoint is used to Authenticate Customer", nickname = "customerLogin")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer Login Success"), @ApiResponse(code = 200, message = "Customer Login Success")})
    ResponseEntity<String> customerLogin(@RequestBody CustomerDto dto) {
        return new ResponseEntity<>(customerService.customerLogin(dto), HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    @CrossOrigin
    @ApiOperation(value = "Getting customers Information", notes = "This Endpoint is used to Get all customers information", nickname = "customersInfo")
    @ApiResponses(value = {@ApiResponse(code = 503, message = "Server Error"),
            @ApiResponse(code = 500, message = "Server Error"), @ApiResponse(code = 400, message = "Service Not Found"),
            @ApiResponse(code = 202, message = "Customer List"), @ApiResponse(code = 200, message = "Customer List")})
    ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
}
