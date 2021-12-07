package com.kanwar.micro.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class CircuilBreakerController {
	Logger log = LoggerFactory.getLogger(CircuilBreakerController.class);
	
	@GetMapping("/simple-api")
	@Retry(name= "default")
	public String getSimpleAPI() {
		log.info("call the CircuilBreakerController ");
		ResponseEntity<String> entity= new  RestTemplate().getForEntity("http://localhost:7889/dump", String.class);
		return entity.getBody();
	}

}
