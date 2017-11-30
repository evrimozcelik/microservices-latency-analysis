package com.mycompany.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceD extends AbstractService{
	
	private int fibonacci = 30;
	private int responseSize = 100;
	
	@PostMapping("/ServiceD")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		return process(request, fibonacci, responseSize);
	}
}
