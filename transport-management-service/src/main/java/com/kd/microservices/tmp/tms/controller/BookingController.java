package com.kd.microservices.tmp.tms.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.microservices.tmp.tms.constant.Constants;
import com.kd.microservices.tmp.tms.dto.BookingDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/transport/booking")
@Slf4j
public class BookingController {

	@Autowired
	private RabbitTemplate template;
	
    @GetMapping("/book-ticket")
	public ResponseEntity<String> bookTicket() {
		log.info("BookingController - bookTicket");
		BookingDto bookingDto = new BookingDto("Kedar", "kedar@test.com", "1234567890", "TestVen", "TestVen123",
				"TestVeh", "TestVeh123", "7A", "3");
		template.convertAndSend(Constants.EXCHANGE, Constants.ROUTING_KEY, bookingDto);

		return new ResponseEntity<>(Constants.SUCCESS, HttpStatus.OK);
	}
}
