package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {
	 private List<String> listMsg = new ArrayList<String>();
	 
	 public void addMsg(String msg) {
		 listMsg.add(msg);
	 }
	 public String getAllMsg() {
		 return listMsg.toString();
	 }
}
