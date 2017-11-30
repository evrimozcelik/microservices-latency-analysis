package com.mycompany.services;

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
	
	@PostMapping("/ServiceA")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		callServiceB(request);
		return process(request, fibonacci, responseSize);
	}
	
	private void callServiceB(ServiceRequest request) {
		if(isMicroservicesMode()) {
			serviceBClient.doService(request);
		} else {
			serviceB.doService(request); 
		}
	}
}
