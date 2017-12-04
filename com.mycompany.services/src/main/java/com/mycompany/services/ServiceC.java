package com.mycompany.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceC.class);
	
	@PostMapping("/ServiceC")
	public ServiceResponse doService(@RequestBody ServiceRequest request) {
		logger.info("ServiceC started, calling Service D");
		callServiceD(request);
		return process(request, fibonacci, responseSize);
	}
	
	private void callServiceD(ServiceRequest request) {
		if(isMicroservicesMode()) {
			logger.info("Calling ServiceD as a microservice");
			serviceDClient.doService(request);
		} else {
			logger.info("Calling ServiceD as a module");
			serviceD.doService(request); 
		}
	}
	
}
