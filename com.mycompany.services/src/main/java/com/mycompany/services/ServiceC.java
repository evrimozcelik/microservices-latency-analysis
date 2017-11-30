package com.mycompany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.clients.ServiceDClient;
import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@RestController
public class ServiceC extends AbstractService{
	
	private int fibonacci = 30;
	private int responseSize = 100;
	
	@Autowired ServiceD serviceD;
	@Autowired ServiceDClient serviceDClient;
	
	@PostMapping("/ServiceC")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		callServiceD(request);
		return process(request, fibonacci, responseSize);
	}
	
	private void callServiceD(ServiceRequest request) {
		if(isMicroservicesMode()) {
			serviceDClient.doService(request);
		} else {
			serviceD.doService(request); 
		}
	}
	
}
