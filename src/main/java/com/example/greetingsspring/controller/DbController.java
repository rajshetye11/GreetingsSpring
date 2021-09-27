package com.example.greetingsspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingsspring.repo.ICustomer;
import com.example.greetingsspring.service.Customer;


@RestController
@RequestMapping("/Customer")
public class DbController {
	@Autowired
	ICustomer repositoryCustomer;

	
	@RequestMapping(value = {"/save","/setName"})
	public void save(@RequestBody Customer customer){
		repositoryCustomer.save(customer);
	}
	
	@GetMapping("/getData")
	public List<Customer> getData() {
		return repositoryCustomer.findAll();
	}
	
	@GetMapping("/getSpecificData")
	public String getSpecificData(@RequestParam Integer id) {
		return repositoryCustomer.findById(id).get().getName();
	}
	
	@DeleteMapping("/del")
	public void deleteData(@RequestParam Integer id) {
		repositoryCustomer.delete(repositoryCustomer.findById(id).get());
	}
}
