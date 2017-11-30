package com.mycompany.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.data.ServiceRequest;
import com.mycompany.data.ServiceResponse;

@FeignClient(name="ServiceB")
public interface ServiceBClient {

	@RequestMapping(method=RequestMethod.POST, value="/ServiceB")
	public ServiceResponse doService(@RequestBody ServiceRequest request);
}
