package com.kd.microservices.tmp.ns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.microservices.tmp.ns.dto.CustomerDto;
import com.kd.microservices.tmp.ns.service.NotifyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notify")
@Slf4j
public class NotifyController {
	@Autowired
	private NotifyService service;

	@GetMapping("/notify-user")
	public void notifyUser(@RequestBody CustomerDto customer) {
		log.info("NotifyController - notifyUser");
		service.notifyUser(customer.getFirstName() + " " + customer.getLastName(), customer.getEmailId());
	}
}
