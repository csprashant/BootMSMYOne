package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MesageProducer {
	@Autowired KafkaTemplate< String,String> template;
	
	@Value("${app.topic.name}")
	private String topicName;
	
	public String msgGenerator(String msg) {
		template.send(topicName,msg);
		return "message Send";
	}

}
