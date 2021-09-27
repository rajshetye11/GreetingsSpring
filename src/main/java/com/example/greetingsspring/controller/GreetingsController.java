package com.example.greetingsspring.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingsspring.model.GreetingsModel;
import com.example.greetingsspring.service.GreetingsService;

@RestController
public class GreetingsController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private GreetingsService greetingsService = new GreetingsService();
	
	@RequestMapping("/greeting")
	public GreetingsModel greeting(@RequestParam (value="name",defaultValue="world") String name) {
		return new GreetingsModel(counter.incrementAndGet(),String.format(template, name));
	}
	
	@RequestMapping(value = {"/query"},method = RequestMethod.GET)
	public GreetingsModel greeting(@RequestParam (value="name",defaultValue="") String name,@RequestParam (value="firstName",defaultValue="") String firstName,@RequestParam (value="lastName",defaultValue="") String lastName) {
		 
		return new GreetingsModel(counter.incrementAndGet(),"Hello "+ name + firstName + " " + lastName);
		
	}
	
	@PostMapping(value="/addGreeting")
	public void addGretings(@RequestParam (value="name",defaultValue="") String name,@RequestParam (value="firstName",defaultValue="") String firstName,@RequestParam (value="lastName",defaultValue="") String lastName) {
		greetingsService.addGreeting( new GreetingsModel(counter.incrementAndGet(),"Hello "+ name + firstName + " " + lastName));
		System.out.println(greetingsService.greetingList.size());
	}

	
	@RequestMapping(value = {"/get/{id}"},method = RequestMethod.GET)
	public GreetingsModel greeting(@PathVariable long id) {	 
		return greetingsService.findGreeting(id);
	}
	
	@RequestMapping(value = {"/getAll"},method = RequestMethod.GET)
	public String allMessages() {	 
		return greetingsService.listAllMessage();
	}
}
	