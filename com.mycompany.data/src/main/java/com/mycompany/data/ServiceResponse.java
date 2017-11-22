package com.mycompany.data;

import java.util.List;

public class ServiceResponse {
	
	private String reqId;
	private List<ResponseItem> items;
	
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public List<ResponseItem> getItems() {
		return items;
	}
	public void setItems(List<ResponseItem> items) {
		this.items = items;
	}
	
	

}
