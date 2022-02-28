package com.nt.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {
	
	@Autowired RestTemplate template;
	
	Logger log = org.slf4j.LoggerFactory.getLogger(PaymentController.class);
	
	@GetMapping("payment")
	public String processPayment() {
		log.info("Come to payment controller");
		return "payment done";
		
	}

}
