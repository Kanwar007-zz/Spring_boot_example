package com.kanwar.micro.limitservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanwar.micro.limitservices.beans.Limit;
import com.kanwar.micro.limitservices.configration.limitConfigration;

@RestController
public class limitServicesController {
	@Autowired
    private limitConfigration configration;

	
	@GetMapping("/limit")
	public Limit retriveLimit() {
		
		return new Limit(configration.getMinimun(),configration.getMaximun());
		//return new Limit(1,10);
	}
}
