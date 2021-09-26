package com.example.greetingsspring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingsspring.model.GreetingsModel;

@RestController
public class GreetingsController {
	
	@RequestMapping("/json")
	public List<GreetingsModel> getGreetings(){
		return Arrays.asList(
				new GreetingsModel("Raaj","Shetye"),
				new GreetingsModel("Abc","Xyz")
						);
	}
}
