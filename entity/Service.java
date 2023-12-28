package com.ilp.entity;

public class Service {
	@Override
	public String toString() {
		return "Service [serviceCode=" + serviceCode + ", serviceName=" + serviceName + ", rate=" + rate + "]";
	}
	private String serviceCode;
	private String serviceName;
	private int rate;
	public Service(String serviceCode, String serviceName, int rate) {

		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.rate = rate;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	

}
