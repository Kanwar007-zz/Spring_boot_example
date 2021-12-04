package com.kanwar.micro.currencyconversionservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kanwar.micro.currencyconversionservices.CurrencyExchangeProxy;
import com.kanwar.micro.currencyconversionservices.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			  @PathVariable String to,
			  @PathVariable BigDecimal quantity ) {
		
		HashMap<String, String> uriVariable = new HashMap<String, String>();
		uriVariable.put("from",from);
		uriVariable.put("to",to);
		
		
		
		ResponseEntity<CurrencyConversion> resposne =new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class, uriVariable);
	        
		CurrencyConversion currencyConversion= 	resposne.getBody();
		return new CurrencyConversion(currencyConversion.getId(), from, to,currencyConversion.getConversionMultiple(), quantity, 
				quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
	}

	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from,
			  @PathVariable String to,
			  @PathVariable BigDecimal quantity ) {
		
	
		CurrencyConversion currencyConversion= 	proxy.retriveCurrencyExchange(from, to);
		return new CurrencyConversion(currencyConversion.getId(), from, to,currencyConversion.getConversionMultiple(), quantity, 
				quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
	}
}
