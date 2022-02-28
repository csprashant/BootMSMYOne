package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.MesageProducer;
import com.nt.service.MessageStore;

@RestController
public class KfakaMessageController {
	
	@Autowired private  MesageProducer producre;
	@Autowired private MessageStore  store;

 @GetMapping("send")
 public String sendMsg(@RequestParam("msg") String msg) {
	 String msgGenerator = producre.msgGenerator(msg);
	 return "<h1>"+msgGenerator+"</h1>";
 }
 
 @GetMapping("readAll")
 public String readAll() {
	 return store.getAllMsg();
 }

}
