package com.mycompany.services;

import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.airline.util.Fibonacci;
import com.mycompany.data.ResponseItem;
import com.mycompany.data.ServiceConfig;
import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

abstract public class AbstractService {
	
	@Value("${microservicesMode}") private boolean microservicesMode;
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);

	public ServiceResponse process(ServiceRequest request, int fibonacci, int responseSize) {
		String serviceName = this.getClass().getSimpleName();
		
		logger.debug("{}.process started. Request: {}", serviceName, request);
		
		ServiceResponse response = new ServiceResponse();
		
		if(request != null) {
			response.setReqId(request.getReqId());
			
			ServiceConfig serviceConfig = request.getServiceConfig().get(serviceName);
			if(serviceConfig!=null) {
				if(serviceConfig.getFibonacci()!=null) {
					fibonacci = serviceConfig.getFibonacci();
				}
				if(serviceConfig.getResponseSize()!=null) {
					responseSize = serviceConfig.getResponseSize();
				}
			}
			
		} else {
			response.setReqId("No Request Id");
		}
		
		response.setItems(new ArrayList<>());
		
		// Generate Payload
		for(int i=0; i<responseSize; i++) {
			ResponseItem item = new ResponseItem();
			item.setValue(UUID.randomUUID().toString());
			response.getItems().add(item);
		}
		
		// Some processing
		Fibonacci.calculate(fibonacci); 
		
		logger.debug("{}.process completed", serviceName);
		
		return response;
	}

	public boolean isMicroservicesMode() {
		return microservicesMode;
	}
	
}
