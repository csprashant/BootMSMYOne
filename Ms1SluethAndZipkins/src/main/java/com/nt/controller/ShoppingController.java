package com.nt.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {
	
	@Autowired RestTemplate template;
	
	Logger log = org.slf4j.LoggerFactory.getLogger(ShoppingController.class);
	
	@GetMapping("shopping")
	public String processShopping() {
		log.info("Come to shopping controller");
		String reso = template.getForObject("http://localhost:9902/billing",String.class);
		log.info("Came  from billing controller");
		return "shopping done"+reso;
		
	}

}
