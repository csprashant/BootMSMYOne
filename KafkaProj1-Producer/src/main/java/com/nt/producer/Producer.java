package com.nt.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;



public class Producer {
	public static void main(String s[]) {
		Properties prop = new Properties();
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		
		KafkaProducer<String,String> producer = new KafkaProducer<String, String>(prop);
		
		String msg="Welcome to prashant";
		String topic="nit-tpc-feb";
		
		ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic, msg);
		
		producer.send(record);
		producer.flush();
		producer.close();
		System.out.println("Message send");
	}

}
