package com.kd.microservices.tmp.tms.controller;

import com.kd.microservices.tmp.tms.dto.BookingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transport/booking")
public class BookingController {

    public ResponseEntity<String> bookTransport(@RequestBody BookingDto dto) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
