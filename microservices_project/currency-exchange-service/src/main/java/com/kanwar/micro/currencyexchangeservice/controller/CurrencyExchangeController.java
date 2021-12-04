package com.kanwar.micro.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kanwar.micro.currencyexchangeservice.bean.CurrencyExchange;
import com.kanwar.micro.currencyexchangeservice.bean.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired(required=true)
	private CurrencyExchangeRepository repository;
	
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public CurrencyExchange retriveExhange(
			  @PathVariable String from,
			  @PathVariable String to){
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000l,from,to,BigDecimal.valueOf(50));
		
		CurrencyExchange currencyExchange=repository.findByFromAndTo(from, to);
		
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
	
}
