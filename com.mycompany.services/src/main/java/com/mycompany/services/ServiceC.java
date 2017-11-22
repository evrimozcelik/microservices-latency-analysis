package com.mycompany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceC extends AbstractService{
	
	private int fibonacci = 40;
	private int responseSize = 500;
	
	@Autowired ServiceD serviceD;
	
	@PostMapping("/ServiceC")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		serviceD.doService(request);
		return process(request, fibonacci, responseSize);
	}
}
