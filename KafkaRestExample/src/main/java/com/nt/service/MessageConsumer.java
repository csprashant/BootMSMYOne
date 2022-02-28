package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class MessageConsumer {

	@Autowired MessageStore store;
	
	@KafkaListener(topics = "${app.topic.name}", groupId = "grp1")
	public void readMsg(String msg) {
		store.addMsg(msg);
	}
}
