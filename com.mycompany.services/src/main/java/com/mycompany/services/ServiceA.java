package com.mycompany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceA extends AbstractService{
	
	private int fibonacci = 40;
	private int responseSize = 500;
	
	@Autowired ServiceB serviceB;
	
	@PostMapping("/ServiceA")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		serviceB.doService(request); 
		return process(request, fibonacci, responseSize);
	}
}
