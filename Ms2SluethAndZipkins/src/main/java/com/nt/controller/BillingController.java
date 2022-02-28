package com.nt.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BillingController {
	
	@Autowired RestTemplate template;
	
	Logger log = org.slf4j.LoggerFactory.getLogger(BillingController.class);
	
	@GetMapping("billing")
	public String processBilling() {
		log.info("Come to billing controller");
		String reso = template.getForObject("http://localhost:9903/payment",String.class);
		log.info("Come  from payment controller");
		return "billing done "+reso;
		
	}

}
