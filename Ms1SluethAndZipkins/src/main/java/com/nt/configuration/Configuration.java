package com.nt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	public Sampler getSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
