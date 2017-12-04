package com.mycompany.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.clients.ServiceBClient;
import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceA extends AbstractService{
	
	private int fibonacci = 30;
	private int responseSize = 100;
	
	@Autowired ServiceB serviceB;
	@Autowired ServiceBClient serviceBClient;
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceA.class);
	
	@PostMapping("/ServiceA")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		logger.info("ServiceA started, calling Service B");
		callServiceB(request);
		return process(request, fibonacci, responseSize);
	}
	
	private void callServiceB(ServiceRequest request) {
		if(isMicroservicesMode()) {
			logger.info("Calling ServiceB as microservice");
			serviceBClient.doService(request);
		} else {
			logger.info("Calling ServiceB as module");
			serviceB.doService(request); 
		}
	}
}
