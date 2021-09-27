package com.example.greetingsspring.service;

import java.util.ArrayList;
import java.util.List;

import com.example.greetingsspring.model.GreetingsModel;

public class GreetingsService {
	public static List<GreetingsModel> greetingList = new ArrayList<>();

	public void addGreeting(GreetingsModel greeting) {
		greetingList.add(greeting);
	}
	
	public GreetingsModel findGreeting(long id) {
		for ( GreetingsModel x : greetingList) {
			if (x.getId()==id) return x;
		}
		return new GreetingsModel(0, null);
	}
	
	public String listAllMessage() {
		String all = "";
		for ( GreetingsModel x : greetingList) {
			all += x.toString();
		}
		return all;
	}
	
	public void editMessage(long id, String message) {
		for( GreetingsModel x : greetingList) {
			if (x.getId()==id) x.setMessage(message);
		}
	}
}
