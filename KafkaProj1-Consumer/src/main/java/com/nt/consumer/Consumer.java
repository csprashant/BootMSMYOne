package com.nt.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class Consumer {
	public static void main(String s[]) {
		Properties prop = new Properties();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		prop.put(ConsumerConfig.GROUP_ID_CONFIG,"grp1_consumer");
		
		@SuppressWarnings("resource")
		KafkaConsumer<String,String> consumer =  new KafkaConsumer<String, String>(prop);
		consumer.subscribe(Arrays.asList("nit-tpc-feb"));
		while(true) {
			ConsumerRecords<String,String> records =  consumer.poll(Duration.ofMillis(2000));
			for(ConsumerRecord<String,String> record:records) {
				System.out.println("Msg-->"+record.value());
			}
		}
		
	}

}
