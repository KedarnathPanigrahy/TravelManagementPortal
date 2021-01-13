package com.kd.microservice.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/transport-service-fallback")
    public String transportServiceFallBackMethod() {
        return "Travel Management Portal is taking longer time then expected, Please try again after some time.";
    }

    @GetMapping("/customer-service-fallback")
    public String customerServiceFallBackMethod() {
        return "Customer Service is taking longer time then expected, Please try again after some time.";
    }

    @GetMapping("/transport-franchise-service-fallback")
    public String transportFranchiseServiceFallBackMethod() {
        return "Transport Service is taking longer time then expected, Please try again after some time.";
    }
    
    @GetMapping("/notification-service-fallback")
    public String notificationServiceFallBackMethod() {
        return "Notification Service is taking longer time then expected, Please try again after some time.";
    }
}
