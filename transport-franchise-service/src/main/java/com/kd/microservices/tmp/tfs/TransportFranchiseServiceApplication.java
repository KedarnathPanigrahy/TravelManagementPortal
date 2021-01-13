package com.kd.microservices.tmp.tfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransportFranchiseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportFranchiseServiceApplication.class, args);
	}

}
