package com.mycompany.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceB extends AbstractService{
	
	private int fibonacci = 30;
	private int responseSize = 100;
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceB.class);
	
	@PostMapping("/ServiceB")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		logger.info("ServiceB started");
		return process(request, fibonacci, responseSize);
	}
}
