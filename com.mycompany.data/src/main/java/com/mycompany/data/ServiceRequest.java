package com.mycompany.data;

import java.util.Map;

public class ServiceRequest {
	
	private String reqId;
	private Map<String, ServiceConfig> serviceConfig;
	
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public Map<String, ServiceConfig> getServiceConfig() {
		return serviceConfig;
	}
	public void setServiceConfig(Map<String, ServiceConfig> serviceConfig) {
		this.serviceConfig = serviceConfig;
	}
	
	
}
