package com.nt.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBusControler {
	
	@GetMapping("/test")
	public String testmathod() {
		return " login to normal page";
	}
	
	@GetMapping("/after")
	public String afterLogin() {
		return " You have success full loginedin to mybus.com";
	}
	
	@GetMapping("/user")
	public Authentication userInfo(Principal p) {
		System.out.println(p.getName());
	return SecurityContextHolder.getContext().getAuthentication();
	}
	
	

}
