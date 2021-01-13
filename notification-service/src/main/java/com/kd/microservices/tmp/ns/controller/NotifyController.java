package com.kd.microservices.tmp.ns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.microservices.tmp.ns.service.NotifyService;

@RestController
@RequestMapping("/notify")
public class NotifyController {
	@Autowired
	private NotifyService service;

	@GetMapping("/notify-user")
	public void notifyUser() {
		service.notifyUser("Kedar", "Kedarnath.Panigrahy@Lumen.com");
	}
}
