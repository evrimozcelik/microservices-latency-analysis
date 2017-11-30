package com.mycompany.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceB extends AbstractService{
	
	private int fibonacci = 30;
	private int responseSize = 100;
	
	@PostMapping("/ServiceB")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		return process(request, fibonacci, responseSize);
	}
}
