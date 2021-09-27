package com.example.greetingsspring.service;

import java.util.ArrayList;
import java.util.List;

import com.example.greetingsspring.model.GreetingsModel;

public class GreetingsService {
	public static List<GreetingsModel> greetingList = new ArrayList<>();

	public void addGreeting(GreetingsModel greeting) {
		greetingList.add(greeting);
	}
}
