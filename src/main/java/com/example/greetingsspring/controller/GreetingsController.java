package com.example.greetingsspring.controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingsspring.model.GreetingsModel;

@RestController
public class GreetingsController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public GreetingsModel greeting(@RequestParam (value="name",defaultValue="world") String name) {
		return new GreetingsModel(counter.incrementAndGet(),String.format(template, name));
	}
	
	@RequestMapping(value = {"/query"},method = RequestMethod.GET)
	public GreetingsModel greeting(@RequestParam (value="name",defaultValue="") String name,@RequestParam (value="firstName",defaultValue="") String firstName,@RequestParam (value="lastName",defaultValue="") String lastName) {
		 
		return new GreetingsModel(counter.incrementAndGet(),"Hello "+ name + firstName + " " + lastName);
		
	}
	
}
