package com.example.greetingsspring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.greetingsspring.service.Customer;

public interface ICustomer extends JpaRepository<Customer,Integer>{

}
